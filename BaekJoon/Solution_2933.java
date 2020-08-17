import java.util.*;
import java.io.*;

public class Solution_2933 {
	static char[][] map;
	static int R, C;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, 1, -1 };
	static List<int[]> clusters = new ArrayList<>();

	public static int BFS(int x, int y, boolean[][] visited) {
		Queue<int[]> queue = new LinkedList<>();
		int min = Integer.MAX_VALUE;

		clusters.clear();
		visited[x][y] = true;
		queue.offer(new int[] { x, y });
		clusters.add(new int[] { x, y });

		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			for (int i = 0; i < 4; ++i) {
				int nx = current[0] + dx[i];
				int ny = current[1] + dy[i];

				if (!(0 <= nx && nx < R && 0 <= ny && ny < C))
					continue;

				if (visited[nx][ny])
					continue;

				if (map[nx][ny] == '.')
					continue;

				visited[nx][ny] = true;
				queue.offer(new int[] { nx, ny });
				clusters.add(new int[] { nx, ny });
				min = Math.min(min, nx);
			}
		}

		return min;
	}

	public static boolean isSeparated() {
		boolean[][] visited = new boolean[R][C];

		for (int i = R - 1; i >= 0; --i) {
			for (int j = 0; j < C; ++j) {
				if (map[i][j] == '.' || visited[i][j])
					continue;

				int n = BFS(i, j, visited);

				if (n > 0)
					return true;
			}
		}

		return false;
	}

	public static void DownCluster() {
		for (int[] cluster : clusters)
			map[cluster[0]][cluster[1]] = '.';

		int down_dist = Integer.MAX_VALUE;
		for (int[] cluster : clusters) {
			int dist = 1;

			while (cluster[0] - dist > 0 && map[cluster[0] - dist - 1][cluster[1]] == '.')
				++dist;

			down_dist = Math.min(down_dist, dist);
		}

		for (int[] cluster : clusters)
			map[cluster[0] - down_dist][cluster[1]] = 'x';
	}

	public static void FromLeftThrowing(int r) {
		int idx = 0;

		while (idx < C && map[r][idx] == '.')
			++idx;

		if (idx < C)
			map[r][idx] = '.';
	}

	public static void FromRightThrowing(int r) {
		int idx = C - 1;

		while (idx >= 0 && map[r][idx] == '.')
			--idx;

		if (idx >= 0)
			map[r][idx] = '.';
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int i = R - 1; i >= 0; --i)
			map[i] = br.readLine().toCharArray();

		int N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; ++i) {
			if ((i & 1) == 0)
				FromLeftThrowing(Integer.parseInt(st.nextToken()) - 1);
			else
				FromRightThrowing(Integer.parseInt(st.nextToken()) - 1);

			if (isSeparated())
				DownCluster();

//			bw.write(i + " sss\n");
//			for (int k = R - 1; k >= 0; --k) {
//				for (int j = 0; j < C; ++j)
//					bw.write(map[k][j] + "");
//				bw.newLine();
//			}
//			bw.newLine();
		}

		for (int i = R - 1; i >= 0; --i) {
			for (int j = 0; j < C; ++j)
				bw.write(map[i][j] + "");
			bw.newLine();
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
