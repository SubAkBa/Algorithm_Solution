
public class Solution_ValidTicTacToeState {

	public static boolean validTicTacToe(String[] board) {
		int N = 3;
		int[][] aState = new int[N][N];
		int[][] bState = new int[N][N];

		boolean canAWin = false, canBWin = false;
		int xCount = 0, oCount = 0;

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (board[i].charAt(j) == 'X') {
					++xCount;

					aState[0][i] |= (1 << j);
					aState[1][j] |= (1 << i);

					if (i == j)
						aState[2][0] |= (1 << j);

					if (i == (N - j - 1))
						aState[2][1] |= (1 << j);

					for (int p = 0; p < N; ++p) {
						for (int q = 0; q < N; ++q) {
							if (aState[p][q] == (1 << N) - 1)
								canAWin = true;
						}
					}
				} else if (board[i].charAt(j) == 'O') {
					++oCount;

					bState[0][i] |= (1 << j);
					bState[1][j] |= (1 << i);

					if (i == j)
						bState[2][0] |= (1 << j);

					if (i == (N - j - 1))
						bState[2][1] |= (1 << j);

					for (int p = 0; p < N; ++p) {
						for (int q = 0; q < N; ++q) {
							if (bState[p][q] == (1 << N) - 1)
								canBWin = true;
						}
					}
				}
			}
		}

		return isValid(xCount, oCount, canAWin, canBWin);
	}

	public static boolean isValid(int xCount, int oCount, boolean canAWin, boolean canBWin) {

		// B(O) 가 이겼는데, A(X) 가 더 진행한 상황
		if (xCount - 1 == oCount && canBWin)
			return false;

		// A(X) 가 이겼는데, B(O) 가 더 진행한 상황
		if (xCount == oCount && canAWin)
			return false;

		// B(O) 가 더 많이 놓은 상황 (A(X)가 선이므로 A >= B가 성립해야 한다.)
		if (xCount <= oCount - 1)
			return false;

		// A(X) 가 2턴 이상 더 많이 놓은 상황 (A(X)와 B(O)의 턴 차이는 0 또는 1이여야 한다.)
		if (xCount - 2 >= oCount)
			return false;

		// A(X) 도 이겼고, B(O) 도 이긴 상황
		// 즉, 누군가가 이긴 상태에서 더 진행한 상황
		if (canAWin && canBWin)
			return false;

		return true;
	}

	public static void main(String[] args) {
		System.out.println(validTicTacToe(new String[] { "O  ", "   ", "   " })); // false
		System.out.println(validTicTacToe(new String[] { "XOX", " X ", "   " })); // false
		System.out.println(validTicTacToe(new String[] { "XXX", "   ", "OOO" })); // false
		System.out.println(validTicTacToe(new String[] { "XOX", "O O", "XOX" })); // true
		System.out.println(validTicTacToe(new String[] { "XXX", "XOO", "OO " })); // false
		System.out.println(validTicTacToe(new String[] { "OXX", "XOX", "OXO" })); // false
		System.out.println(validTicTacToe(new String[] { "XXX", "OOX", "OOX" })); // true
	}
}
