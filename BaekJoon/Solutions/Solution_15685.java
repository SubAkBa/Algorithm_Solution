import java.util.*;
import java.io.*;

public class Solution_15685 {
	static ArrayList<Curve> curves;
	static boolean[][] ispart;

	public static void DragonCurve() {
		int[] dx = { 1, 0, -1, 0 }, dy = { 0, -1, 0, 1 };

		for (Curve curve : curves) {
			StringBuilder sb = new StringBuilder();
			sb.append(curve.dir);

			int nx = curve.x + dx[curve.dir];
			int ny = curve.y + dy[curve.dir];
			ispart[curve.x][curve.y] = true;
			ispart[nx][ny] = true;

			for (int gen = 1; gen <= curve.gen; gen++) {
				StringBuilder rev = new StringBuilder(sb.toString()).reverse();

				for (int i = 0; i < rev.length(); i++) {
					int nextdir = rev.charAt(i) - '0' + 1;

					if (nextdir == 4)
						nextdir = 0;

					nx += dx[nextdir];
					ny += dy[nextdir];

					ispart[nx][ny] = true;

					sb.append(nextdir);
				}
			}
		}
	}

	public static class Curve {
		int x, y, dir, gen;

		public Curve(int x, int y, int dir, int gen) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.gen = gen;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		ispart = new boolean[101][101];
		curves = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());

			curves.add(new Curve(x, y, d, g));
		}

		DragonCurve();

		int count = 0;
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if (ispart[i - 1][j - 1] && ispart[i - 1][j] && ispart[i][j - 1] && ispart[i][j])
					count++;
			}
		}

		bw.write(count + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
