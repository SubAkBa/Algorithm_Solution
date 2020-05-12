import java.util.*;
import java.io.*;

public class Solution_stemcellculture {

	public static int SpreadCell(int[][] cellmap, int K, ArrayList<Point> cell) {
		LinkedList<Point> list = new LinkedList<>();
		CustomComparator cc = new CustomComparator();
		int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, 1, -1 };

		list.addAll(cell);

		while ((K--) > 0) {
			int qsize = list.size();
			Collections.sort(list, cc);

			while ((qsize--) > 0) {
				Point curcell = list.pollFirst();

				if (curcell.curlife == 0) {
					if (curcell.curlife == 0) {
						for (int i = 0; i < 4; i++) {
							int nx = curcell.x + dx[i];
							int ny = curcell.y + dy[i];

							if (cellmap[nx][ny] == 0) {
								cellmap[nx][ny] = cellmap[curcell.x][curcell.y];
								list.add(new Point(nx, ny, cellmap[nx][ny], cellmap[nx][ny]));
							}
						}
					}
				}
				
				if (curcell.curlife == -(curcell.life - 1))
					continue;

				curcell.curlife--;
				list.add(curcell);
			}
		}

		return list.size();
	}

	public static class CustomComparator implements Comparator<Point> {
		public int compare(Point p1, Point p2) {
			return -1 * (p1.life - p2.life);
		}
	}

	public static class Point {
		int x, y, life, curlife;

		public Point(int x, int y, int life, int curlife) {
			this.x = x;
			this.y = y;
			this.life = life;
			this.curlife = curlife;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine()), count = 0;

		while ((count++) < T) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] cellmap = new int[500][500];
			ArrayList<Point> cell = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < M; j++) {
					cellmap[i + 150][j + 150] = Integer.parseInt(st.nextToken());

					if (cellmap[i + 150][j + 150] != 0)
						cell.add(new Point(i + 150, j + 150, cellmap[i + 150][j + 150], cellmap[i + 150][j + 150]));
				}
			}

			bw.write("#" + count + " " + SpreadCell(cellmap, K, cell) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
