import java.util.*;
import java.io.*;

public class bfs_11559_solution {
	static char[][] map;
	static int row = 12, col = 6;
	static boolean[][] visited;
	static ArrayList<Point> bomblist;

	public static void BFS(char ch, int x, int y) {
		int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, 1, -1 };
		int nx, ny;

		visited[x][y] = true;
		bomblist.add(new Point(x, y));

		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];

			if (0 <= nx && nx < row && 0 <= ny && ny < col) {
				if (map[nx][ny] == ch && !visited[nx][ny])
					BFS(ch, nx, ny);
			}
		}
	}

	public static void DownPuyo() {
		Queue<Character> queue = new LinkedList<Character>();
		Queue<Character> output = new LinkedList<Character>();

		for (int j = 0; j < col; j++) {

			for (int i = 0; i < row; i++)
				queue.offer(map[i][j]);

			for (int i = 0; i < row; i++) {
				if (queue.peek() != '.')
					output.offer(queue.poll());
				else
					queue.offer(queue.poll());
			}

			while (!queue.isEmpty())
				output.offer(queue.poll());

			for (int i = 0; i < row; i++)
				map[i][j] = output.poll();
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		bomblist = new ArrayList<Point>();
		visited = new boolean[12][6];
		map = new char[12][6];

		boolean isenabled = true;
		int chain = 0;

		for (int i = row - 1; i >= 0; i--)
			map[i] = br.readLine().toCharArray();

		while (isenabled) {
			isenabled = false;

			for (int i = 0; i < row; i++) {

				for (int j = 0; j < col; j++) {

					if (map[i][j] != '.') {

						for (int v = 0; v < row; v++)
							Arrays.fill(visited[v], false);

						BFS(map[i][j], i, j);

						if (bomblist.size() >= 4) {
							isenabled = true;

							for (int k = 0; k < bomblist.size(); k++)
								map[bomblist.get(k).x][bomblist.get(k).y] = '.';
						}

						bomblist.clear();
					}
				}
			}

			if (isenabled)
				chain++;

			DownPuyo();
		}

		System.out.println(chain);
	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}