import java.util.*;
import java.io.*;

public class bfs_2583_solution {
	static int[][] map;
	static int xlen, ylen;
	static int count = 0, area = 0;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, 1, -1 };

	public static void OutofSquareArea(int x, int y) {
		map[x][y] = 1;
		area++;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (0 <= nx && nx < xlen && 0 <= ny && ny < ylen) {
				if (map[nx][ny] == 0)
					OutofSquareArea(nx, ny);
			}
		}
	}

	public static void FillRectangleValue(Point lb, Point ru) {

		for (int i = lb.x; i < ru.x; i++) {
			for (int j = lb.y; j < ru.y; j++)
				map[i][j] = 1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		String[] mapinfo = br.readLine().split(" ");

		xlen = Integer.parseInt(mapinfo[0]);
		ylen = Integer.parseInt(mapinfo[1]);
		int rectcount = Integer.parseInt(mapinfo[2]);

		map = new int[xlen][ylen];

		for (int r = 0; r < rectcount; r++) {
			String[] rectinfo = br.readLine().split(" ");

			FillRectangleValue(new Point(Integer.parseInt(rectinfo[1]), Integer.parseInt(rectinfo[0])),
					new Point(Integer.parseInt(rectinfo[3]), Integer.parseInt(rectinfo[2])));

			for (int i = 0; i < xlen * ylen; i++) {
				if (map[i / ylen][i % ylen] != 1)
					map[i / ylen][i % ylen] = 0;
			}
		}

		for (int i = 0; i < xlen * ylen; i++) {
			int tx = i / ylen;
			int ty = i % ylen;
			area = 0;
			if (map[tx][ty] == 0) {
				OutofSquareArea(tx, ty);
				count++;
				pq.offer(area);
			}
		}

		System.out.println(pq.size());

		while (!pq.isEmpty())
			System.out.print(pq.poll() + " ");
	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}