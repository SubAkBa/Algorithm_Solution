import java.util.*;

public class Solution_NextGreaterElementII {

	public static int[] nextGreaterElements(int[] nums) {
		int len = nums.length;

		if (len == 0)
			return nums;

		int[] result = new int[len];

		result[len - 1] = -1;

		if (len == 1)
			return result;

		for (int i = len - 2; i >= 0; i--) {
			int idx = i + 1;

			while (nums[i] >= nums[idx] && result[idx] != -1)
				idx = result[idx];

			if (nums[i] < nums[idx])
				result[i] = idx;
			else
				result[i] = -1;
		}

		for (int i = len - 1; i >= 0; i--) {
			if (result[i] != -1)
				continue;

			int idx = (i + 1) % len;

			while (nums[i] >= nums[idx] && result[idx] != -1)
				idx = result[idx];

			if (nums[i] < nums[idx])
				result[i] = idx;
			else
				result[i] = -1;
		}

		for (int i = 0; i < len; i++) {
			if (result[i] != -1)
				result[i] = nums[result[i]];
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(nextGreaterElements(new int[] { 1, 2, 1 })));
		System.out.println(Arrays.toString(nextGreaterElements(new int[] { 1, 2, 3, 2, 3, 1, 5, 6, 4, 5 })));
	}

}
