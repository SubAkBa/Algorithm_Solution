
public class Solution_terrainedit {

	public static long BlockCost(int[][] land, long mid, int N, int P, int Q) {
		long total = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (land[i][j] < mid)
					total += (mid - land[i][j]) * P;
				else if (land[i][j] > mid)
					total += (land[i][j] - mid) * Q;
			}
		}

		return total;
	}

	public static long solution(int[][] land, int P, int Q) {
		int N = land.length;
		long answer = Long.MAX_VALUE, left = Long.MAX_VALUE, right = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				left = Math.min(left, land[i][j]);
				right = Math.max(right, land[i][j]);
			}
		}

		while (left < right) {
			long mid = (left + right) / 2;

			long lcost = BlockCost(land, mid, N, P, Q);
			long rcost = BlockCost(land, mid + 1, N, P, Q);

			if (lcost < rcost)
				right = mid;
			else if (lcost > rcost)
				left = mid + 1;
			else {
				answer = Math.min(answer, lcost);
				break;
			}
		}

		return (answer == Long.MAX_VALUE ? BlockCost(land, (left + right) / 2, N, P, Q) : answer);
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 1, 2 }, { 2, 3 } }, 3, 2));
		System.out.println(solution(new int[][] { { 4, 4, 3 }, { 3, 2, 2 }, { 2, 1, 0 } }, 5, 3));
	}

}
