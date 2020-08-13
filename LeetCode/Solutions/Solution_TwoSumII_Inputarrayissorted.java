import java.util.*;

public class Solution_TwoSumII_Inputarrayissorted {
	public static int[] twoSum(int[] numbers, int target) {
		int left = 0, right = numbers.length - 1, sum = 0;

		while ((sum = numbers[left] + numbers[right]) != target) {
			if (sum > target)
				--right;
			else if (sum < target)
				++left;
		}
		
		return new int[] { left + 1, right + 1 };
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[] { 2, 7, 11, 15 }, 9))); // [1, 2]
		System.out.println(Arrays.toString(twoSum(new int[] { 1, 2, 3, 4, 5 }, 9))); // [4, 5]
	}

}
