import java.util.*;

public class Solution_IncreasingTripletSubsequence {

	public static boolean increasingTriplet(int[] nums) {
		int[] lens = new int[nums.length];

		if (nums.length == 0)
			return false;

		lens[0] = 1;

		for (int i = 1; i < nums.length; i++) {
			int maxlen = 0;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					maxlen = Math.max(maxlen, lens[j]);
				}
			}
			lens[i] = maxlen + 1;

			if (lens[i] >= 3)
				return true;
		}

		return false;
	}

	public static void main(String[] args) {
		System.out.println(increasingTriplet(new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(increasingTriplet(new int[] { 5, 4, 3, 2, 1 }));
		System.out.println(increasingTriplet(new int[] { 2, 1, 5, 0, 3 }));
		System.out.println(increasingTriplet(new int[] {}));
	}

}
