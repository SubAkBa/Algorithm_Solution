
public class Solution_LongestMountaininArray {

	public static int longestMountain(int[] A) {
		int len = A.length, answer = 0, idx = 0;
		boolean existedUp = false, existedDown = false;

		for (int i = 1; i < len; ++i) {
			if (A[i] - A[i - 1] > 0) {
				if (!existedUp || existedDown) {
					existedUp = true;
					existedDown = false;
					idx = i - 1;
				}
			} else if (existedUp && A[i] - A[i - 1] < 0) {
				answer = Math.max(answer, i - idx + 1);
				existedDown = true;
			} else if (A[i] - A[i - 1] == 0)
				existedUp = false;
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(longestMountain(new int[] { 2, 1, 4, 7, 3, 2, 5 })); // 5
		System.out.println(longestMountain(new int[] { 2, 2, 2 })); // 0
		System.out.println(longestMountain(new int[] { 1, 2, 3, 4, 5, 6, 7 })); // 0
		System.out.println(longestMountain(new int[] { 1, 2, 3, 4, 5, 6, 7, 6 })); // 8
		System.out.println(longestMountain(new int[] { 0, 1, 0 })); // 3
		System.out.println(longestMountain(new int[] { 1, 1, 2, 2, 1, 1 })); // 0
		System.out.println(longestMountain(new int[] { 1, 2, 3, 2, 1, 2, 3, 4, 3, 2, 1 })); // 0
	}
}
