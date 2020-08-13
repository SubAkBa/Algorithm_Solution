
public class Solution_MaximumSumofTwoNon_OverlappingSubarrays {

	public static int maxSumTwoNoOverlap(int[] A, int L, int M) {
		int len = A.length;

		for (int i = 1; i < len; ++i)
			A[i] += A[i - 1];

		int answer = A[L + M - 1], Lmax = A[L - 1], Mmax = A[M - 1];

		for (int i = L + M; i < len; ++i) {
			Lmax = Math.max(Lmax, A[i - M] - A[i - M - L]);
			Mmax = Math.max(Mmax, A[i - L] - A[i - M - L]);

			answer = Math.max(answer, Math.max(Lmax + A[i] - A[i - M], Mmax + A[i] - A[i - L]));
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(maxSumTwoNoOverlap(new int[] { 0, 6, 5, 2, 2, 5, 1, 9, 4 }, 1, 2)); // 20
		System.out.println(maxSumTwoNoOverlap(new int[] { 3, 8, 1, 3, 2, 1, 8, 9, 0 }, 3, 2)); // 29
		System.out.println(maxSumTwoNoOverlap(new int[] { 2, 1, 5, 6, 0, 9, 5, 0, 3, 8 }, 4, 3)); // 31
	}

}
