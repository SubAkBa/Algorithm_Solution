import java.util.*;
import java.io.*;

public class Solution_3055 {
	static Point cave;
	static LinkedList<Point> puddles, hedgehog;
	static char[][] map;
	static int N, M, minute = 0;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, 1, -1 };

	public static String PerMinute() {
		minute++;
		SpreadPuddles();
		Move();
		
		if (cave == null)
			return Integer.toString(minute);
		else if (!isPossible() || hedgehog.size() == 0)
			return "KAKTUS";
		else
			return "";
	}

	public static boolean isPossible() {

		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + cave.x;
			int ny = dy[i] + cave.y;

			if (0 <= nx && nx < N && 0 <= ny && ny < M) {
				if (map[nx][ny] == '*' || map[nx][ny] == 'X')
					continue;

				return true;
			}
		}

		return false;
	}

	public static void Move() {
		Queue<Point> queue = new LinkedList<>();

		queue.addAll(hedgehog);
		hedgehog.clear();

		while (!queue.isEmpty()) {
			Point h = queue.poll();

			if (map[h.x][h.y] == 'S')
				map[h.x][h.y] = '.';

			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + h.x;
				int ny = dy[i] + h.y;

				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					if (map[nx][ny] == 'D') {
						cave = null;
						return;
					}

					if (!visited[nx][ny] && map[nx][ny] == '.') {
						visited[nx][ny] = true;
						map[nx][ny] = 'S';
						hedgehog.add(new Point(nx, ny));
					}
				}
			}
		}
	}

	public static void SpreadPuddles() {
		Queue<Point> queue = new LinkedList<>();

		queue.addAll(puddles);
		puddles.clear();

		while (!queue.isEmpty()) {
			Point puddle = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + puddle.x;
				int ny = dy[i] + puddle.y;

				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					if (map[nx][ny] == '.' || map[nx][ny] == 'S') {
						map[nx][ny] = '*';
						puddles.add(new Point(nx, ny));
					}
				}
			}
		}
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
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M];
		puddles = new LinkedList<>();
		hedgehog = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp[j];
				if (temp[j] == 'S') {
					hedgehog.add(new Point(i, j));
					visited[i][j] = true;
				} else if (temp[j] == 'D')
					cave = new Point(i, j);
				else if (temp[j] == '*')
					puddles.add(new Point(i, j));
			}
		}
		String str = "";

		while (str.equals(""))
			str = PerMinute();
			
		bw.write(str + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
