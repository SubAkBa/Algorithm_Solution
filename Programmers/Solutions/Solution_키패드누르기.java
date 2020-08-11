import java.util.*;

public class Solution_pushkeypad {
	static char[][] path = { { '1', '2', '3' }, { '4', '5', '6' }, { '7', '8', '9' }, { '*', '0', '#' } };
	static int row = 4, col = 3;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };

	public static int BFS(int number, Point hand) {
		boolean[][] visited = new boolean[row][col];
		Queue<Point> queue = new LinkedList<>();
		int step = 0;

		queue.offer(hand);
		visited[hand.x][hand.y] = true;

		while (true) {
			int size = queue.size();

			while ((--size) >= 0) {
				Point current = queue.poll();

				if (path[current.x][current.y] == (number + '0')) {
					hand.SetPoint(current.x, current.y);
					return step;
				}

				for (int i = 0; i < 4; i++) {
					int nx = dx[i] + current.x;
					int ny = dy[i] + current.y;

					if (!(0 <= nx && nx < row && 0 <= ny && ny < col))
						continue;

					if (visited[nx][ny])
						continue;

					queue.offer(new Point(nx, ny));
					visited[nx][ny] = true;
				}
			}

			++step;
		}
	}

	public static String solution(int[] numbers, String hand) {
		StringBuilder answer = new StringBuilder();
		int len = numbers.length;
		Point left = new Point(3, 0), right = new Point(3, 2);

		for (int i = 0; i < len; ++i) {
			switch (numbers[i]) {
			case 1:
			case 4:
			case 7:
				left.SetPoint((numbers[i] - 1) / 3, 0);
				answer.append("L");
				break;
			case 3:
			case 6:
			case 9:
				right.SetPoint((numbers[i] - 1) / 3, 2);
				answer.append("R");
				break;
			default:
				left.SetPrev(left);
				right.SetPrev(right);

				int left_step = BFS(numbers[i], left);
				int right_step = BFS(numbers[i], right);

				if (left_step == right_step) {
					switch (hand) {
					case "right":
						left.SetPoint(left.px, left.py);
						answer.append("R");
						break;
					case "left":
						right.SetPoint(right.px, right.py);
						answer.append("L");
						break;
					}
				} else if (left_step > right_step) {
					left.SetPoint(left.px, left.py);
					answer.append("R");
				} else {
					right.SetPoint(right.px, right.py);
					answer.append("L");
				}
			}
		}

		return answer.toString();
	}

	public static class Point {
		int x, y;
		int px, py;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public void SetPoint(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public void SetPrev(Point p) {
			this.px = p.x;
			this.py = p.y;
		}
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 }, "right")); // "LRLLLRLLRRL"
		System.out.println(solution(new int[] { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 }, "left")); // "LRLLRRLLLRR"
		System.out.println(solution(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 }, "right")); // "LLRLLRLLRL"
	}

}
