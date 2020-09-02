import java.util.*;
import java.io.*;

public class Solution_13460 {

	public static boolean CheckRedPos(Point tempRed, Point tempBlue, int dir) {
		boolean check = false;

		switch (dir) {
		case 0:
			if (tempRed.y > tempBlue.y)
				check = true;
			break;
		case 1:
			if (tempRed.x > tempBlue.x)
				check = true;
			break;
		case 2:
			if (tempRed.y < tempBlue.y)
				check = true;
			break;
		case 3:
			if (tempRed.x < tempBlue.x)
				check = true;
			break;
		}

		return check;
	}

	public static int Escape(char[][] map, Point red, Point blue) {
		Queue<Point> queue = new LinkedList<>();
		int[] dx = { 0, 1, 0, -1 }, dy = { 1, 0, -1, 0 };
		int count = 0;
		HashSet<String> state = new HashSet<>();

		queue.offer(red);
		queue.offer(blue);

		while (!queue.isEmpty()) {

			if ((count++) == 10)
				break;

			int size = queue.size() / 2;

			while ((size--) > 0) {
				Point curRed = queue.poll();
				Point curBlue = queue.poll();

				if (state.contains(curRed.x + "" + curRed.y + "" + curBlue.x + "" + curBlue.y))
					continue;

				state.add(curRed.x + "" + curRed.y + "" + curBlue.x + "" + curBlue.y);

				for (int i = 0; i < 4; i++) {
					Point tempRed = new Point(curRed.x, curRed.y);
					Point tempBlue = new Point(curBlue.x, curBlue.y);

					boolean escblue = false;
					boolean checkPos = CheckRedPos(curRed, curBlue, i);

					while (map[tempBlue.x + dx[i]][tempBlue.y + dy[i]] != '#') {
						tempBlue.x += dx[i];
						tempBlue.y += dy[i];

						if (map[tempBlue.x][tempBlue.y] == 'O')
							escblue = true;
					}

					if (escblue)
						continue;

					while (map[tempRed.x + dx[i]][tempRed.y + dy[i]] != '#') {
						tempRed.x += dx[i];
						tempRed.y += dy[i];

						if (map[tempRed.x][tempRed.y] == 'O')
							return count;
					}

					if (tempRed.x == tempBlue.x && tempRed.y == tempBlue.y) {
						if (checkPos) {
							tempBlue.x -= dx[i];
							tempBlue.y -= dy[i];
						} else {
							tempRed.x -= dx[i];
							tempRed.y -= dy[i];
						}
					}

					queue.offer(tempRed);
					queue.offer(tempBlue);
				}
			}
		}

		return -1;
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

		char[][] map = new char[N][M];
		Point[] bead = new Point[2];

		for (int i = 0; i < N; i++) {
			char[] ctr = br.readLine().toCharArray();

			for (int j = 0; j < M; j++) {
				map[i][j] = ctr[j];

				if (ctr[j] == 'R')
					bead[0] = new Point(i, j);
				else if (ctr[j] == 'B')
					bead[1] = new Point(i, j);
			}
		}

		bw.write(Escape(map, bead[0], bead[1]) + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
