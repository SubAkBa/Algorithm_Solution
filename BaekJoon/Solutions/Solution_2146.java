import java.util.*;
import java.io.*;

public class Solution_2146 {
	static boolean[][] visited;
	static int N;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };

	public static void NumberingContinent(int x, int y, int num, LinkedList<Point> conti) {
		Queue<Point> queue = new LinkedList<>();

		visited[x][y] = true;
		map[x][y] = num;
		queue.offer(new Point(x, y));
		conti.add(new Point(x, y));

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (0 <= nx && nx < N && 0 <= ny && ny < N) {
					if (!visited[nx][ny] && map[nx][ny] == 1) {
						queue.offer(new Point(nx, ny));
						visited[nx][ny] = true;
						map[nx][ny] = num;
						conti.add(new Point(nx, ny));
					}
				}
			}
		}
	}

	public static int ConstructingBridge(LinkedList<Point> conti, int num) {
		int bridge = 0;
		Queue<Point> queue = new LinkedList<>();

		queue.addAll(conti);

		while (!queue.isEmpty()) {
			int continum = queue.size();

			for (int k = 0; k < continum; k++) {
				Point cur = queue.poll();

				for (int i = 0; i < 4; i++) {
					int nx = cur.x + dx[i];
					int ny = cur.y + dy[i];

					if (0 <= nx && nx < N && 0 <= ny && ny < N) {
						if(map[nx][ny] == 0) {
							if(!visited[nx][ny]) {
								queue.offer(new Point(nx, ny));
								visited[nx][ny] = true;
							}
						} else if(map[nx][ny] != num)
							return bridge;
					}
				}
			}

			bridge++;
		}

		return bridge;
	}

	public static int solution(int N, int[][] map) {
		int answer = Integer.MAX_VALUE;
		int num = 2;
		LinkedList<Point> conti = new LinkedList<>();
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					for (int k = 0; k < N; k++)
						Arrays.fill(visited[k], false);
					conti.clear();
					NumberingContinent(i, j, num, conti);
					answer = Math.min(answer, ConstructingBridge(conti, num++));
				}
			}
		}

		return answer;
	}

	public static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		bw.write(solution(N, map) + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
