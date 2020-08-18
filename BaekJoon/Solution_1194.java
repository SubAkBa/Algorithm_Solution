import java.util.*;
import java.io.*;

public class Solution_1194 {
	static int N, M;

	public static int BFS(char[][] map, boolean[][][] visited, int[] start) {
		Queue<int[]> queue = new LinkedList<>();
		int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, 1, -1 };
		int dist = 0;

		visited[0][start[0]][start[1]] = true;
		queue.offer(new int[] { start[0], start[1], 0 });

		while (!queue.isEmpty()) {

			++dist;

			int size = queue.size();

			while ((--size) >= 0) {
				int[] current = queue.poll();

				for (int i = 0; i < 4; ++i) {
					int nx = current[0] + dx[i];
					int ny = current[1] + dy[i];
					int key = current[2];

					if (!(0 <= nx && nx < N && 0 <= ny && ny < M))
						continue;

					if (visited[key][nx][ny])
						continue;

					if (map[nx][ny] == '1')
						return dist;

					if (map[nx][ny] == '#')
						continue;

					if ('A' <= map[nx][ny] && map[nx][ny] <= 'F' && (key & (1 << (map[nx][ny] - 'A'))) == 0)
						continue;

					if ('a' <= map[nx][ny] && map[nx][ny] <= 'f')
						key |= 1 << (map[nx][ny] - 'a');

					visited[key][nx][ny] = true;
					queue.offer(new int[] { nx, ny, key });

				}
			}
		}

		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];
		boolean[][][] visited = new boolean[1 << 6][N][M];
		int[] start = null;

		for (int i = 0; i < N; ++i) {
			char[] ch = br.readLine().toCharArray();

			for (int j = 0; j < M; ++j) {
				map[i][j] = ch[j];

				if (map[i][j] == '0')
					start = new int[] { i, j };
			}
		}

		bw.write(BFS(map, visited, start) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
