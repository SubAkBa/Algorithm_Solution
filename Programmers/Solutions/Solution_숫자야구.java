import java.util.*;

public class Solution_숫자야구 {

	public static int solution(int[] A, int[] B) {
		int score = 0;
		int len = A.length;

		Arrays.sort(A);
		Arrays.sort(B);

		for (int aidx = 0, bidx = 0; bidx < len; ++bidx) {
			if (A[aidx] < B[bidx]) {
				++aidx;
				++score;
			}
		}

		return score;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 5, 1, 3, 7 }, new int[] { 2, 2, 6, 8 })); // 3
		System.out.println(solution(new int[] { 2, 2, 2, 2 }, new int[] { 1, 1, 1, 1 })); // 0
	}
}
