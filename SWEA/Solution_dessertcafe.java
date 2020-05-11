import java.util.*;
import java.io.*;

public class Solution_dessertcafe {
	static int[] dx = { 1, 1, -1, -1 }, dy = { 1, -1, -1, 1 };
	static int N, type;
	static int[][] cafe;

	public static void SearchCafe(int[] dessert, Point start, int dir, int count, int x, int y) {
		int nx = x + dx[dir];
		int ny = y + dy[dir];

		if (start.x == nx && start.y == ny) {
			type = Math.max(type, count);
			return;
		}

		if (!(0 <= nx && nx < N && 0 <= ny && ny < N) || dessert[cafe[nx][ny]] == 1)
			return;

		dessert[cafe[nx][ny]] = 1;

		SearchCafe(dessert, start, dir, count + 1, nx, ny);

		if (dir < 3)
			SearchCafe(dessert, start, dir + 1, count + 1, nx, ny);

		dessert[cafe[nx][ny]] = 0;
	}

	public static class Point {
		int x, y;

		public Point() {
		}

		public void SetPoint(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine()), count = 0;

		while ((count++) < T) {
			N = Integer.parseInt(br.readLine());
			cafe = new int[N][N];
			type = -1;
			int[] dessert = new int[101];
			Point start = new Point();

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				for (int j = 0; j < N; j++)
					cafe[i][j] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < N - 2; i++) {
				for (int j = 1; j < N - 1; j++) {
					start.SetPoint(i, j);
					dessert[cafe[i][j]] = 1;
					SearchCafe(dessert, start, 0, 1, i, j);
					dessert[cafe[i][j]] = 0;
				}
			}

			bw.write("#" + count + " " + type + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
