import java.util.*;
import java.io.*;

public class bfs_2573_solution {
	static int row, col;
	static int[][] map;
	static boolean[][] visited;

	public static void GlacierBFS(ArrayList<GlacierPoint> point, int x, int y) {
		int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
		int nx, ny, count = 0;

		Queue<GlacierPoint> queue = new LinkedList<>();
		queue.offer(new GlacierPoint(x, y, 0));
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			GlacierPoint cur = queue.poll();
			count = 0;

			for (int i = 0; i < 4; i++) {
				nx = dx[i] + cur.x;
				ny = dy[i] + cur.y;

				if (0 <= nx && nx < row && 0 <= ny && ny < col) {
					if (!visited[nx][ny] && map[nx][ny] != 0) {
						visited[nx][ny] = true;
						queue.offer(new GlacierPoint(nx, ny, 0));
					} else if (map[nx][ny] == 0)
						count++;
				}
			}

			point.add(new GlacierPoint(cur.x, cur.y, count));
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] infos = br.readLine().split(" ");
		int glaciercount = 0, year = -1;

		row = Integer.parseInt(infos[0]);
		col = Integer.parseInt(infos[1]);

		ArrayList<GlacierPoint> point = new ArrayList<>();

		map = new int[row][col];
		visited = new boolean[row][col];

		for (int i = 0; i < row; i++) {
			String[] mapinfo = br.readLine().split(" ");

			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(mapinfo[j]);
			}
		}

		while (glaciercount < 2) {

			glaciercount = 0;

			for (int i = 0; i < row; i++)
				Arrays.fill(visited[i], false);

			for (int i = 0; i < row; i++) {

				for (int j = 0; j < col; j++) {

					if (!visited[i][j] && map[i][j] != 0) {
						GlacierBFS(point, i, j);

						glaciercount++;
					}
				}
			}

			for (int k = 0; k < point.size(); k++) {
				int temp = map[point.get(k).x][point.get(k).y] - point.get(k).seacount;

				if (temp < 0)
					map[point.get(k).x][point.get(k).y] = 0;
				else
					map[point.get(k).x][point.get(k).y] = temp;
			}
			
			point.clear();

			if (glaciercount == 0) {
				year = 0;
				break;
			} else
				year++;

		}

		System.out.println(year);
	}
}

class GlacierPoint {
	int x, y, seacount;

	public GlacierPoint(int x, int y, int seacount) {
		this.x = x;
		this.y = y;
		this.seacount = seacount;
	}
}