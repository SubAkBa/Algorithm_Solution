import java.util.*;

public class Solution_HowManyNumbersAreSmallerThantheCurrentNumber {

//	public static void Update(int[] tree, int clen, int idx, int diff) {
//		while (idx < clen) {
//			tree[idx] += diff;
//			idx += (idx & -idx);
//		}
//	}
//
//	public static int Query(int[] tree, int idx) {
//		int sum = 0;
//		while (idx > 0) {
//			sum += tree[idx];
//			idx -= (idx & -idx);
//		}
//
//		return sum;
//	}

//	public static int[] smallerNumbersThanCurrent(int[] nums) {
//		int clen = 101, nlen = nums.length;
//		int[] counts = new int[clen];
//		int[] tree = new int[clen + 1];
//
//		for (int i = 0; i < nlen; ++i)
//			++counts[nums[i]];
//
//		for (int i = 1; i <= clen; ++i)
//			Update(tree, clen, i, counts[i - 1]);
//
//		int[] answer = new int[nlen];
//		for (int i = 0; i < nlen; ++i)
//			answer[i] = Query(tree, nums[i]);
//
//		return answer;
//	}

	public static int[] smallerNumbersThanCurrent(int[] nums) {
		int clen = 101, nlen = nums.length;
		int[] counts = new int[clen];

		for (int i = 0; i < nlen; ++i)
			++counts[nums[i]];

		for (int i = 1; i < clen; ++i)
			counts[i] += counts[i - 1];

		int[] answer = new int[nlen];

		for (int i = 0; i < nlen; ++i) {
			if (nums[i] == 0)
				answer[i] = 0;
			else
				answer[i] = counts[nums[i] - 1];
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[] { 8, 1, 2, 2, 3 })));
		System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[] { 6, 5, 4, 8 })));
		System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[] { 7, 7, 7, 7 })));
	}

}
