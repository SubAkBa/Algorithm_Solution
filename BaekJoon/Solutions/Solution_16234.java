import java.io.*;
import java.util.*;

public class Solution_16234 {

	public static int Find_Union(List<int[]> list, boolean[][] visited, int[][] map, int N, int L, int R, int x,
			int y) {
		Queue<int[]> queue = new LinkedList<>();
		int[] d = { -1, 0, 1, 0, -1 };

		int sum = map[x][y];
		list.add(new int[] { x, y });
		queue.offer(new int[] { x, y });
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			for (int i = 0; i < 4; ++i) {
				int nx = current[0] + d[i];
				int ny = current[1] + d[i + 1];

				if (!(0 <= nx && nx < N && 0 <= ny && ny < N))
					continue;

				if (visited[nx][ny])
					continue;

				if (!(L <= Math.abs(map[current[0]][current[1]] - map[nx][ny])
						&& Math.abs(map[current[0]][current[1]] - map[nx][ny]) <= R))
					continue;
				else {
					list.add(new int[] { nx, ny });
					sum += map[nx][ny];
				}

				visited[nx][ny] = true;
				queue.offer(new int[] { nx, ny });
			}
		}

		if (list.size() == 1) {
			list.clear();
			sum = 0;
		}

		return sum;
	}

	public static void Move(List<int[]> list, int sum, int[][] map) {
		int n = sum / list.size();

		for (int[] l : list)
			map[l[0]][l[1]] = n;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; ++j)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		boolean canMove = true;
		int count = 0;

		boolean[][] visited = new boolean[N][N];
		List<int[]> list = new ArrayList<>();

		while (canMove) {
			canMove = false;

			for (int i = 0; i < N; ++i)
				Arrays.fill(visited[i], false);

			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if (visited[i][j])
						continue;

					int sum = Find_Union(list, visited, map, N, L, R, i, j);

					if (list.size() > 0) {
						canMove = true;
						Move(list, sum, map);
						list.clear();
					}
				}
			}

			if (canMove)
				++count;
		}

		bw.write(count + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
