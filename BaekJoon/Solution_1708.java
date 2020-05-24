import java.util.*;
import java.io.*;

public class Solution_1708 {
	static Point[] p;

	public static int ccw(Point a, Point b, Point c) {
		long cal = (long) (b.x - a.x) * (c.y - a.y) - (long) (c.x - a.x) * (b.y - a.y);

		if (cal > 0)
			return 1;
		else if (cal < 0)
			return -1;
		else
			return 0;
	}

	public static class Point implements Comparable<Point> {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int compareTo(Point p1) {
			int v = ccw(new Point(p[0].x, p[0].y), this, p1);

			if (v > 0)
				return -1;

			if (v < 0)
				return 1;

			return (Math.abs(this.x) + this.y) - (Math.abs(p1.x) + p1.y);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		p = new Point[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			p[i] = new Point(x, y);
		}

		for (int i = 0; i < N; i++) {
			if ((p[0].y > p[i].y) || (p[0].y == p[i].y && p[0].x > p[i].x)) {
				Point temp = p[0];
				p[0] = p[i];
				p[i] = temp;
			}
		}

		Arrays.sort(p, 1, N);

		Stack<Integer> stack = new Stack<>();

		for (int next = 0; next < N; next++) {

			while (stack.size() >= 2) {
				int second = stack.pop();
				int first = stack.peek();

				if (ccw(p[first], p[second], p[next]) > 0) {
					stack.push(second);
					break;
				}
			}

			stack.push(next);
		}
		bw.write(stack.size() + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
