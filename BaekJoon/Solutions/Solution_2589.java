import java.util.*;
import java.io.*;

public class Solution_2589 {
	static char[][] map;
	static int[][] dist;
	static boolean[][] visited;
	static int row, col;

	public static int Treasure_Hunt(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, 1, -1 };
		int nx, ny, max = 0;

		visited[x][y] = true;
		dist[x][y] = 0;
		queue.offer(new Point(x, y));

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				nx = dx[i] + cur.x;
				ny = dy[i] + cur.y;

				if (0 <= nx && nx < row && 0 <= ny && ny < col) {
					if (!visited[nx][ny] && map[nx][ny] == 'L') {
						queue.offer(new Point(nx, ny));
						visited[nx][ny] = true;
						dist[nx][ny] = dist[cur.x][cur.y] + 1;	  // 출발지점부터의 거리를 계산하고
						max = Math.max(dist[nx][ny], max);		  // 최댓값을 갱신한다.
					}
				}
			}
		}

		return max;
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

		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());

		int max = 0;
		map = new char[row][col];
		visited = new boolean[row][col];
		dist = new int[row][col];

		for (int i = 0; i < row; i++)
			map[i] = br.readLine().toCharArray();

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (map[i][j] == 'L') {
					for (int k = 0; k < row; k++)
						Arrays.fill(visited[k], false);
					max = Math.max(max, Treasure_Hunt(i, j));
				}
			}
		}

		bw.write(max + " ");

		bw.flush();
		bw.close();
		br.close();
	}

}
