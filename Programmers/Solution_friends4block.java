import java.util.*;

public class Solution_friends4block {

	public static void Find4Block(Set<Point> rmlist, char[][] chrboard, Point start) {
		int[] dx = { 1, 1, 0 }, dy = { 0, 1, 1 };
		int nx, ny;
		List<Point> list = new ArrayList<>();

		list.add(new Point(start.x, start.y));

		for (int i = 0; i < 3; i++) {
			nx = dx[i] + start.x;
			ny = dy[i] + start.y;

			if (0 <= nx && nx < chrboard.length && 0 <= ny && ny < chrboard[0].length) {
				if (chrboard[start.x][start.y] == chrboard[nx][ny]) {
					list.add(new Point(nx, ny));
				} else
					break;
			}
		}

		if (list.size() == 4) {
			for (Point p : list) {
				if (!rmlist.contains(p))
					rmlist.add(p);
			}
		}
	}

	public static void Break4Block(Set<Point> rmlist, char[][] chrboard) {
		Iterator<Point> iter = rmlist.iterator();

		while (iter.hasNext()) {
			Point cur = iter.next();

			chrboard[cur.x][cur.y] = '.';
		}

		rmlist.clear();
	}

	public static void DownBlock(char[][] chrboard) {
		Queue<Character> queue = new LinkedList<>();

		for (int y = 0; y < chrboard[0].length; y++) {
			for (int x = 0; x < chrboard.length; x++) {

				if (chrboard[x][y] != '.')
					queue.offer(chrboard[x][y]);
			}

			int idx = 0;

			while (!queue.isEmpty())
				chrboard[idx++][y] = queue.poll();

			for (int i = idx; i < chrboard.length; i++)
				chrboard[i][y] = '.';
		}

	}

	public static int solution(int m, int n, String[] board) {
		int answer = 0;
		Set<Point> rmlist = new HashSet<>();
		char[][] chrboard = new char[m][n];
		boolean canBreak = true;

		for (int i = 0; i < m; i++)
			chrboard[i] = board[m - i - 1].toCharArray();

		while (canBreak) {
			canBreak = false;

			for (int x = 0; x < m; x++) {
				for (int y = 0; y < n; y++)
					Find4Block(rmlist, chrboard, new Point(x, y));
			}
			
			if (!rmlist.isEmpty()) {
				canBreak = true;
				answer += rmlist.size();

				Break4Block(rmlist, chrboard);

				DownBlock(chrboard);
			}

		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(4, 5, new String[] { "CCBDE", "AAADE", "AAABF", "CCBBF" }));
		System.out.println(solution(6, 6, new String[] { "TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ" }));
	}

}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Point))
			return false;

		Point s = (Point) obj;

		return this.x == s.x && this.y == s.y;
	}
}