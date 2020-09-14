import java.util.*;
import java.io.*;

public class Solution_2206 {

	public static int BFS(int N, int M, int[][] map, int[][][] visited) {
		Queue<int[]> queue = new LinkedList<>();
		int[] d = new int[] { -1, 0, 1, 0, -1 };

		visited[0][0][0] = 1;
		queue.offer(new int[] { 0, 0, 0 });

		while (!queue.isEmpty()) {
			int round = queue.size();

			while ((--round) >= 0) {
				int[] current = queue.poll();

//				System.out.println(current[0] + " " + current[1] + " " + current[2]);
//				for (int i = 0; i < N; ++i)
//					System.out.println(Arrays.toString(visited[current[2]][i]));
//				System.out.println();

				if (current[0] == N - 1 && current[1] == M - 1)
					return Math.min(visited[0][N - 1][M - 1], visited[1][N - 1][M - 1]);

				for (int i = 0; i < 4; ++i) {
					int nx = current[0] + d[i];
					int ny = current[1] + d[i + 1];
					int nflag = current[2];

					if (!(0 <= nx && nx < N && 0 <= ny && ny < M))
						continue;

					if (visited[nflag][current[0]][current[1]] + 1 >= visited[nflag][nx][ny])
						continue;

					if (map[nx][ny] == 1) {
						if (nflag == 1)
							continue;
						else {
							nflag = 1;
							visited[nflag][nx][ny] = visited[nflag - 1][current[0]][current[1]] + 1;
							queue.offer(new int[] { nx, ny, nflag });
						}
					} else {
						visited[nflag][nx][ny] = visited[nflag][current[0]][current[1]] + 1;
						queue.offer(new int[] { nx, ny, nflag });
					}

				}
			}
		}

		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int INF = 987654321;

		int[][] map = new int[N][M];
		int[][][] visited = new int[2][N][M];

		for (int i = 0; i < N; ++i) {
			char[] ch = br.readLine().toCharArray();

			Arrays.fill(visited[0][i], INF);
			Arrays.fill(visited[1][i], INF);

			for (int j = 0; j < M; ++j)
				map[i][j] = ch[j] - '0';
		}

		bw.write(BFS(N, M, map, visited) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
