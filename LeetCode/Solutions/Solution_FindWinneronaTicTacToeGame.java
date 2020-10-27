
public class Solution_FindWinneronaTicTacToeGame {

	public static String tictactoe(int[][] moves) {
		int N = 3;
		int[][] aState = new int[N][N]; // 가로, 세로, 대각선
		int[][] bState = new int[N][N];

		int mlen = moves.length;

		for (int i = 0; i < mlen; ++i) {
			int x = moves[i][0];
			int y = moves[i][1];

			if ((i & 1) == 0) { // 홀수 - A
				aState[0][x] |= (1 << y);
				aState[1][y] |= (1 << x);

				if (x == y)
					aState[2][0] |= (1 << y);

				if (x == (N - y - 1))
					aState[2][1] |= (1 << y);

				for (int p = 0; p < N; ++p) {
					for (int q = 0; q < N; ++q) {
						if (aState[p][q] == (1 << N) - 1)
							return "A";
					}
				}
			} else { 			// 짝수 - B
				bState[0][x] |= (1 << y);
				bState[1][y] |= (1 << x);

				if (x == y)
					bState[2][0] |= (1 << y);

				if (x == (N - y - 1))
					bState[2][1] |= (1 << y);

				for (int p = 0; p < N; ++p) {
					for (int q = 0; q < N; ++q) {
						if (bState[p][q] == (1 << N) - 1)
							return "B";
					}
				}
			}

//			Print(N, aState, bState);
		}


		return (mlen == 9 ? "Draw" : "Pending");
	}

	public static void Print(int N, int[][] aState, int[][] bState) {
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				System.out.println("i : " + i + " j : " + j + " " + Integer.toBinaryString(aState[i][j]) + " "
						+ Integer.toBinaryString(bState[i][j]));
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(tictactoe(new int[][] { { 0, 0 }, { 2, 0 }, { 1, 1 }, { 2, 1 }, { 2, 2 } })); // "A"
		System.out.println(tictactoe(new int[][] { { 0, 0 }, { 1, 1 }, { 0, 1 }, { 0, 2 }, { 1, 0 }, { 2, 0 } })); // "B"
		System.out.println(tictactoe(new int[][] { { 0, 0 }, { 1, 1 }, { 2, 0 }, { 1, 0 }, { 1, 2 }, { 2, 1 }, { 0, 1 },
				{ 0, 2 }, { 2, 2 } })); // "Draw"
		System.out.println(tictactoe(new int[][] { { 0, 0 }, { 1, 1 } })); // "Pending"
	}
}
