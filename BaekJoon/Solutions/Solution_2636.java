import java.util.*;
import java.io.*;

public class Solution_2636 {
	static int[] d = { -1, 0, 1, 0, -1 };

	public static void Air_BFS(int N, int M, int[][] cheese_map, boolean[][] visited) {

		Queue<int[]> queue = new LinkedList<>();

		queue.offer(new int[] { 0, 0 });
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			for (int i = 0; i < 4; ++i) {
				int nx = current[0] + d[i];
				int ny = current[1] + d[i + 1];

				if (!(0 <= nx && nx < N && 0 <= ny && ny < M))
					continue;

				if (visited[nx][ny])
					continue;

				if (cheese_map[nx][ny] == 1)
					continue;

				visited[nx][ny] = true;
				queue.offer(new int[] { nx, ny });
			}
		}
	}

	public static void Cheese_BFS(int N, int M, int[][] cheese_map, boolean[][] visited, List<int[]> outside, int x,
			int y) {
		Queue<int[]> queue = new LinkedList<>();

		visited[x][y] = true;
		queue.offer(new int[] { x, y });

		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			boolean isadded = false;
			for (int i = 0; i < 4; ++i) {
				int nx = current[0] + d[i];
				int ny = current[1] + d[i + 1];

				if (visited[nx][ny]) {
					if (cheese_map[nx][ny] == 0 && !isadded) {
						outside.add(new int[] { current[0], current[1] });
						isadded = true;
					}
					continue;
				}

				if (cheese_map[nx][ny] == 0)
					continue;

				visited[nx][ny] = true;
				queue.offer(new int[] { nx, ny });
			}
		}
	}

	public static void Remove_Cheese(int[][] cheese_map, List<int[]> outside) {
		for (int[] point : outside)
			cheese_map[point[0]][point[1]] = 0;

		outside.clear();
	}

//	public static void Print(int[][] cheese_map, List<int[]> outside) {
//		for (int[] p : outside)
//			System.out.println(Arrays.toString(p) + " " + cheese_map[p[0]][p[1]]);
//		System.out.println("size : " + outside.size());
//	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] cheese_map = new int[N][M];
		int cheese_count = 0;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				cheese_map[i][j] = Integer.parseInt(st.nextToken());

				if (cheese_map[i][j] == 1)
					++cheese_count;
			}
		}
		List<int[]> outside = new ArrayList<>();
		boolean[][] visited = new boolean[N][M];
		int last_count = 0, time = 0;

		while (cheese_count > 0) {

			for (int i = 0; i < N; ++i)
				Arrays.fill(visited[i], false);

			++time;

			Air_BFS(N, M, cheese_map, visited);

			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < M; ++j) {
					if (visited[i][j] || cheese_map[i][j] == 0)
						continue;

					Cheese_BFS(N, M, cheese_map, visited, outside, i, j);
				}
			}

//			Print(cheese_map, outside);
			cheese_count -= outside.size();

			if (cheese_count == 0)
				last_count = outside.size();
			else
				Remove_Cheese(cheese_map, outside);
		}

		bw.write(time + "\n" + last_count);
		bw.flush();
		bw.close();
		br.close();
	}
}
