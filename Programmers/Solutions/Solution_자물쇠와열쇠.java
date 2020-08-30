
public class Solution_자물쇠와열쇠 {

	public static int[][] Rotating(int[][] key, int M) {
		int[][] rotate_key = new int[M][M];

		for (int i = 0; i < M * M; ++i) {
			int x = i / M;
			int y = i % M;

			rotate_key[y][M - x - 1] = key[x][y];
		}

		return rotate_key;
	}

	public static boolean isUnlock(int[][] key, int[][] ex_lock, int len, int N, int M, int pos, int hole) {
		for (int kpos = 0; kpos < M * M; ++kpos) {
			int kx = kpos / M;
			int ky = kpos % M;

			int lx = pos / len + kx;
			int ly = pos % len + ky;

			if (!(M - 1 <= lx && lx < N + M - 1 && M - 1 <= ly && ly < N + M - 1))
				continue;

			int key_value = key[kx][ky];
			int lock_value = ex_lock[lx][ly];

			if (key_value == 1 && lock_value == 1)
				return false;

			if (key_value == 1 && lock_value == 0)
				--hole;
		}

		if (hole == 0)
			return true;

		return false;
	}

	public static void Extending(int[][] ex_lock, int[][] lock, int N, int M, int len) {
		for (int i = 0; i < len * len; ++i) {
			int x = i / len;
			int y = i % len;

			if (!(M - 1 <= x && x < N + M - 1 && M - 1 <= y && y < N + M - 1))
				ex_lock[x][y] = 0;
			else
				ex_lock[x][y] = lock[x - M + 1][y - M + 1];
		}
	}

	public static boolean solution(int[][] key, int[][] lock) {
		int M = key.length, N = lock.length;

		int[][][] rotate_key = new int[4][M][M];
		rotate_key[0] = key;
		for (int i = 1; i < 4; ++i)
			rotate_key[i] = Rotating(rotate_key[i - 1], M);

		int hole = 0;
		for (int i = 0; i < N * N; ++i) {
			if (lock[i / N][i % N] == 0)
				++hole;
		}

		int len = N + 2 * (M - 1);
		int[][] ex_lock = new int[len][len];
		Extending(ex_lock, lock, N, M, len);

		for (int k = 0; k < 4; ++k) {
			for (int pos = 0; pos < len * len; ++pos) {
				if (isUnlock(rotate_key[k], ex_lock, len, N, M, pos, hole))
					return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } },
				new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } }));
	}
}
