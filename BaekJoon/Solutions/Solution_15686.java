import java.util.*;
import java.io.*;

public class Solution_15686 {
	static int answer = Integer.MAX_VALUE;

	public static int CalcChickenDist(ArrayList<Point> home, LinkedList<Point> chicken, int M) {
		int dist = 0;

		for (Point h : home) {
			int mindist = Integer.MAX_VALUE;

			for (Point c : chicken)
				mindist = Math.min(mindist, Math.abs(h.x - c.x) + Math.abs(h.y - c.y));

			dist += mindist;
		}

		return dist;
	}

	public static void ChoiceChicken(ArrayList<Point> home, ArrayList<Point> chickenlist, int start,
			LinkedList<Point> chicken, int M) {
		if (chicken.size() == M) {
			answer = Math.min(answer, CalcChickenDist(home, chicken, M));
			return;
		}

		for (int i = start; i < chickenlist.size(); i++) {
			chicken.add(chickenlist.get(i));
			ChoiceChicken(home, chickenlist, i + 1, chicken, M);
			chicken.removeLast();
		}
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
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Point> home = new ArrayList<>();
		ArrayList<Point> chickenlist = new ArrayList<>();
		LinkedList<Point> chicken = new LinkedList<Point>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				int p = Integer.parseInt(st.nextToken());

				if (p == 1)
					home.add(new Point(i, j));
				else if (p == 2)
					chickenlist.add(new Point(i, j));
			}
		}

		ChoiceChicken(home, chickenlist, 0, chicken, M);

		bw.write(answer + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
