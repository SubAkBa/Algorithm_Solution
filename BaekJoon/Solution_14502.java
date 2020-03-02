import java.util.*;
import java.io.*;

public class bfs_14502_solution {
	static int xlen, ylen;
	static int[][] map, cpmap;
	static int maxarea = 0;
	static List<Point> virus = new ArrayList<Point>();
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, 1, -1 };

	public static int SafeArea() {
		int area = 0;

		for (int i = 0; i < xlen; i++) {
			for (int j = 0; j < ylen; j++) {
				if (cpmap[i][j] == 0)
					area++;
			}
		}

		return area;
	}

	public static void SpreadVirus(int x, int y) {
		int nx, ny;

		for (int j = 0; j < 4; j++) {
			nx = dx[j] + x;
			ny = dy[j] + y;

			if (0 <= nx && nx < xlen && 0 <= ny && ny < ylen) {
				if (cpmap[nx][ny] == 0) {
					cpmap[nx][ny] = 2;
					SpreadVirus(nx, ny);
				}
			}
		}
	}

	public static void SetWall(int start, int count) {
		int tx, ty;
		
		if (count == 3) {

			for (int i = 0; i < xlen; i++) {
				for (int j = 0; j < ylen; j++)
					cpmap[i][j] = map[i][j];
			}

			for (Point p : virus)
				SpreadVirus(p.x, p.y);

			maxarea = Math.max(maxarea, SafeArea());

			return;
		}

		for (int i = start; i < xlen * ylen; i++) {
			tx = i / ylen;
			ty = i % ylen;
			
			if (map[tx][ty] == 0) {
				map[tx][ty] = 1;

				SetWall(i + 1, count + 1);

				map[tx][ty] = 0;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] mapidx = br.readLine().split(" ");
		xlen = Integer.parseInt(mapidx[0]);
		ylen = Integer.parseInt(mapidx[1]);
		char[] c = new char[ylen];

		map = new int[xlen][ylen];
		cpmap = new int[xlen][ylen];

		for (int i = 0; i < xlen; i++) {
			c = br.readLine().replaceAll(" ", "").toCharArray();

			for (int j = 0; j < ylen; j++) {
				map[i][j] = Character.getNumericValue(c[j]);

				if (map[i][j] == 2)
					virus.add(new Point(i, j));
			}
		}

		SetWall(0, 0);

		System.out.println(maxarea);
	}

}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}