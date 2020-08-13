import java.util.*;

public class Solution_MinimumIncrementtoMakeArrayUnique {
	public static int minIncrementForUnique(int[] A) {
		int answer = 0;
		Arrays.sort(A);

		for (int i = 1; i < A.length; i++) {
			if (A[i - 1] == A[i]) {
				A[i]++;
				answer++;
			} else if (A[i - 1] > A[i]) {
				int plus = (A[i - 1] - A[i]) + 1;
				A[i] += plus;
				answer += plus;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(minIncrementForUnique(new int[] { 1, 2, 2 }));
		System.out.println(minIncrementForUnique(new int[] { 3, 2, 1, 2, 1, 7 }));
	}

}
