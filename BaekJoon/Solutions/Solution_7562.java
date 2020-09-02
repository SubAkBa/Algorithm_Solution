import java.util.*;
import java.io.*;

public class bfs_7562_solution {

	static boolean[][] visited;
	static int[][] map;
	static int num;

	public static void KnightBFS(Point end, int x, int y, int move) {
		int[] dx = { 1, 2, 2, 1, -1, -2, -2, -1 }, dy = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int nx, ny;

		Queue<Point> queue = new LinkedList<Point>();

		queue.offer(new Point(x, y));
		visited[x][y] = true;
		map[x][y] = move;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			
			if(cur.x == end.x && cur.y == end.y)
				break;

			for (int i = 0; i < 8; i++) {
				nx = dx[i] + cur.x;
				ny = dy[i] + cur.y;
				
				if(0 <= nx && nx < num && 0 <= ny && ny < num) {
					if(!visited[nx][ny] && map[nx][ny] == 0) {
						map[nx][ny] = map[cur.x][cur.y] + 1;
						visited[nx][ny] = true;
						queue.offer(new Point(nx, ny));
					}
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Point start, end;

		int testcase = Integer.parseInt(br.readLine());

		for (int i = 0; i < testcase; i++) {
			num = Integer.parseInt(br.readLine());

			start = new Point(br.readLine().split(" "));
			end = new Point(br.readLine().split(" "));

			map = new int[num][num];
			visited = new boolean[num][num];

			for (int j = 0; j < num; j++) {
				Arrays.fill(visited[j], false);
				Arrays.fill(map[j], 0);
			}

			KnightBFS(end, start.x, start.y, 0);

			sb.append(map[end.x][end.y] + "\n");
		}

		System.out.print(sb.toString());
	}

}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point(String[] posinfo) {
		this.x = Integer.parseInt(posinfo[0]);
		this.y = Integer.parseInt(posinfo[1]);
	}
}