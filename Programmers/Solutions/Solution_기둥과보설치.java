import java.util.*;

public class Solution_기둥과보설치 {

	public static boolean canBuildPillar(boolean[][][] installed, int n, int x, int y) {
		return y == 1 || installed[1][x - 1][y] || installed[0][x][y - 1] || installed[1][x][y];
	}

	public static boolean canBuildBridge(boolean[][][] installed, int n, int x, int y) {
		return installed[0][x][y - 1] || installed[0][x + 1][y - 1]
				|| (installed[1][x - 1][y] && installed[1][x + 1][y]);
	}

	public static boolean canDestroy(boolean[][][] installed, int n) {
		for (int i = 1; i < n + 2; ++i) {
			for (int j = 1; j < n + 2; ++j) {
				if (installed[0][i][j] && !canBuildPillar(installed, n, i, j))
					return false;

				if (installed[1][i][j] && !canBuildBridge(installed, n, i, j))
					return false;
			}
		}

		return true;
	}

	public static int[][] solution(int n, int[][] build_frame) {
		boolean[][][] installed = new boolean[2][n + 3][n + 3];

		int blen = build_frame.length;
		int count = 0;

		for (int i = 0; i < blen; ++i) {
			int x = build_frame[i][0] + 1;
			int y = build_frame[i][1] + 1;
			int type = build_frame[i][2];
			int motion = build_frame[i][3];

			if (motion == 1) { // 설치
				if (type == 0) { // 기둥
					if (!canBuildPillar(installed, n, x, y))
						continue;

					installed[0][x][y] = true;
				} else { // 보
					if (!canBuildBridge(installed, n, x, y))
						continue;

					installed[1][x][y] = true;
				}

				++count;
			} else { // 삭제
				if (type == 0) { // 기둥
					installed[0][x][y] = false;

					if (canDestroy(installed, n)) {
						--count;
						continue;
					}

					installed[0][x][y] = true;
				} else { // 보
					installed[1][x][y] = false;

					if (canDestroy(installed, n)) {
						--count;
						continue;
					}

					installed[1][x][y] = true;
				}
			}
		}

		int[][] answer = new int[count][3];
		int idx = -1;

		for (int i = 1; i < n + 2; ++i) {
			for (int j = 1; j < n + 2; ++j) {
				if (installed[0][i][j])
					answer[++idx] = new int[] { i - 1, j - 1, 0 };

				if (installed[1][i][j])
					answer[++idx] = new int[] { i - 1, j - 1, 1 };
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(solution(5, new int[][] { { 1, 0, 0, 1 }, { 1, 1, 1, 1 }, { 2, 1, 0, 1 },
				{ 2, 2, 1, 1 }, { 5, 0, 0, 1 }, { 5, 1, 0, 1 }, { 4, 2, 1, 1 }, { 3, 2, 1, 1 } })));
		// [[1,0,0],[1,1,1],[2,1,0],[2,2,1],[3,2,1],[4,2,1],[5,0,0],[5,1,0]]
		System.out.println(Arrays.deepToString(solution(5,
				new int[][] { { 0, 0, 0, 1 }, { 2, 0, 0, 1 }, { 4, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 },
						{ 2, 1, 1, 1 }, { 3, 1, 1, 1 }, { 2, 0, 0, 0 }, { 1, 1, 1, 0 }, { 2, 2, 0, 1 } })));
		// [[0,0,0],[0,1,1],[1,1,1],[2,1,1],[3,1,1],[4,0,0]]
	}
}
