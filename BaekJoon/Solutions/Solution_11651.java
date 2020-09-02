import java.util.*;
import java.io.*;

public class Solution_11651 {

	public static class Point implements Comparable<Point> {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int compareTo(Point p) {
			if (this.y == p.y)
				return this.x - p.x;

			return this.y - p.y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		Point[] p = new Point[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			p[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(p);

		for (int i = 0; i < N; i++)
			bw.write(p[i].x + " " + p[i].y + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

}
