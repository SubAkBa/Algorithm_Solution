import java.util.*;
import java.io.*;

public class Solution_2638 {
	static int[] d = { -1, 0, 1, 0, -1 };

	public static void Air_BFS(int[][] map, int N, int M, boolean[][] visited) {
		Queue<int[]> queue = new LinkedList<>();

		visited[0][0] = true;
		queue.offer(new int[] { 0, 0 });

		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			for (int i = 0; i < 4; ++i) {
				int nx = current[0] + d[i];
				int ny = current[1] + d[i + 1];

				if (!(0 <= nx && nx < N && 0 <= ny && ny < M))
					continue;

				if (visited[nx][ny])
					continue;

				if (map[nx][ny] == 1)
					continue;

				visited[nx][ny] = true;
				queue.offer(new int[] { nx, ny });
			}
		}
	}

	public static void Cheese_BFS(List<int[]> rm_cheese, int[][] map, int N, int M, int x, int y, boolean[][] visited) {
		Queue<int[]> queue = new LinkedList<>();

		visited[x][y] = true;
		queue.offer(new int[] { x, y });

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int air_count = 0;

			for (int i = 0; i < 4; ++i) {
				int nx = current[0] + d[i];
				int ny = current[1] + d[i + 1];

				if (visited[nx][ny]) {
					if (map[nx][ny] == 0)
						++air_count;

					continue;
				}

				if (!visited[nx][ny] && map[nx][ny] == 0)
					continue;

				visited[nx][ny] = true;
				queue.offer(new int[] { nx, ny });
			}

			if (air_count >= 2)
				rm_cheese.add(new int[] { current[0], current[1] });
		}
	}

	public static void Remove_Cheese(List<int[]> rm_cheese, int[][] map) {
		for (int[] point : rm_cheese)
			map[point[0]][point[1]] = 0;

		rm_cheese.clear();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		int cheese_count = 0;

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 1)
					++cheese_count;
			}
		}

		List<int[]> rm_cheese = new ArrayList<>();
		boolean[][] visited = new boolean[N][M];
		int time = 0;

		while (cheese_count > 0) {
			++time;

			for (int i = 0; i < N; ++i)
				Arrays.fill(visited[i], false);

			Air_BFS(map, N, M, visited);

			for (int i = 1; i < N - 1; ++i) {
				for (int j = 1; j < M - 1; ++j) {
					if (visited[i][j] || map[i][j] == 0)
						continue;

					Cheese_BFS(rm_cheese, map, N, M, i, j, visited);
				}
			}

			cheese_count -= rm_cheese.size();

			Remove_Cheese(rm_cheese, map);
		}

		bw.write(time + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
