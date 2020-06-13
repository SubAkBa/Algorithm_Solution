import java.util.*;

public class Solution_SlidingPuzzle {
	static int row, col;
//
//	public static class Point {
//		int x, y;
//		int[][] board;
//		String state;
//
//		public Point(int x, int y, int[][] board, String state) {
//			this.x = x;
//			this.y = y;
//			this.board = board;
//			this.state = state;
//		}
//	}
//
//	public static String GetState(int[][] board) {
//		String st = "";
//
//		for (int i = 0; i < row * col; i++)
//			st += board[i / col][i % col];
//
//		return st;
//	}
//
//	public static void Swap(int[][] board, int cx, int cy, int nx, int ny) {
//		int temp = board[cx][cy];
//		board[cx][cy] = board[nx][ny];
//		board[nx][ny] = temp;
//	}
//
//	public static int[][] CopyBoard(int[][] board) {
//		int[][] cpboard = new int[row][col];
//
//		for (int i = 0; i < row; i++)
//			System.arraycopy(board[i], 0, cpboard[i], 0, col);
//
//		return cpboard;
//	}
//
//	public static int Matching(int[][] board, Point zero) {
//		String anstate = "123450";
//		Queue<Point> queue = new LinkedList<>();
//		HashSet<String> state = new HashSet<>();
//		int[] dx = { 0, 1, 0, -1 }, dy = { 1, 0, -1, 0 };
//		int time = 0;
//		
//		if (zero.state.equals(anstate))
//			return time;
//
//		queue.offer(new Point(zero.x, zero.y, zero.board, zero.state));
//		state.add(zero.state);
//
//		while (!queue.isEmpty()) {
//			int size = queue.size();
//			time++;
//
//			while ((size--) > 0) {
//				Point current = queue.poll();
//
//				for (int i = 0; i < 4; i++) {
//					int nx = current.x + dx[i];
//					int ny = current.y + dy[i];
//
//					if (!(0 <= nx && nx < row && 0 <= ny && ny < col))
//						continue;
//
//					int[][] cpboard = CopyBoard(current.board);
//
//					Swap(cpboard, current.x, current.y, nx, ny);
//
//					String tempstate = GetState(cpboard);
//
//					if (tempstate.equals(anstate))
//						return time;
//
//					if (state.contains(tempstate))
//						continue;
//
//					queue.offer(new Point(nx, ny, cpboard, tempstate));
//					state.add(tempstate);
//				}
//			}
//		}
//
//		return -1;
//	}
//
//	public static int slidingPuzzle(int[][] board) {
//		row = 2;
//		col = 3;
//		Point zero = null;
//
//		for (int i = 0; i < row * col; i++) {
//			int x = i / col;
//			int y = i % col;
//
//			if (board[x][y] == 0)
//				zero = new Point(x, y, board, GetState(board));
//		}
//
//		return Matching(board, zero);
//	}

	public static String Swap(String curstate, int i, int j) {
		StringBuilder sb = new StringBuilder(curstate);

		sb.setCharAt(i, curstate.charAt(j));
		sb.setCharAt(j, curstate.charAt(i));

		return sb.toString();
	}

	public static int Matching(String start) {
		String anstate = "123450";
		HashSet<String> state = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		int[][] dir = { { 1, 3 }, { 0, 2, 4 }, { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };
		int time = 0;
		
		queue.offer(start);
		state.add(start);

		while (!queue.isEmpty()) {
			int size = queue.size();

			while ((size--) > 0) {
				String curstate = queue.poll();

				if (curstate.equals(anstate))
					return time;

				int from = curstate.indexOf("0");

				for (int to : dir[from]) {
					String tempstate = Swap(curstate, from, to);

					if (state.contains(tempstate))
						continue;

					queue.offer(tempstate);
					state.add(tempstate);
				}
			}
			
			time++;
		}

		return -1;
	}

	public static int slidingPuzzle(int[][] board) {
		String start = "";
		row = 2;
		col = 3;

		for (int i = 0; i < row * col; i++)
			start += board[i / col][i % col];
		
		return Matching(start);
	}

	public static void main(String[] args) {
		System.out.println(slidingPuzzle(new int[][] { { 1, 2, 3 }, { 4, 0, 5 } }));
		System.out.println(slidingPuzzle(new int[][] { { 1, 2, 3 }, { 5, 4, 0 } }));
		System.out.println(slidingPuzzle(new int[][] { { 4, 1, 2 }, { 5, 0, 3 } }));
		System.out.println(slidingPuzzle(new int[][] { { 3, 2, 4 }, { 1, 5, 0 } }));
		System.out.println(slidingPuzzle(new int[][] { { 1, 2, 3 }, { 4, 5, 0 } }));
	}

}
