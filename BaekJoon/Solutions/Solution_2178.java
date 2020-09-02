import java.io.*;
import java.util.*;

public class bfs_2178_solution {

	public static void BFS(char[][] maze) {
		Queue<Point> queue = new LinkedList<Point>();
		int row = maze.length, col = maze[0].length;

		Boolean[][] visit = new Boolean[row][col];
		int[][] lengths = new int[row][col];

		for (int i = 0; i < row; i++) {
			Arrays.fill(visit[i], false);
			Arrays.fill(lengths[i], 1);
		}

		Point curpoint = new Point(0, 0);

		int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };
		int nx, ny;

		visit[curpoint.x][curpoint.y] = true;
		queue.offer(curpoint);

		while (!queue.isEmpty()) {
			curpoint.setPoint(queue.poll());

			for (int i = 0; i < 4; i++) {
				nx = curpoint.x + dx[i];
				ny = curpoint.y + dy[i];

				if (nx < 0 || nx >= row || ny < 0 || ny >= col) 
					continue;
				if (visit[nx][ny] || (maze[nx][ny] - '0') == 0)
					continue;
				
				visit[nx][ny] = true;
				queue.offer(new Point(nx, ny));
				lengths[nx][ny] = lengths[curpoint.x][curpoint.y] + 1;
			}
		}

		System.out.println(lengths[row - 1][col - 1]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] point = br.readLine().split(" ");
		
		int row = Integer.parseInt(point[0]);
		int col = Integer.parseInt(point[1]);

		char[][] maze = new char[row][col];
		
		for (int i = 0; i < row; i++)
			maze[i] = br.readLine().toCharArray();

		BFS(maze);
	}

}

class Point {
	int x, y;

	public Point() {
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setPoint(Point p) {
		this.x = p.x;
		this.y = p.y;
	}

}