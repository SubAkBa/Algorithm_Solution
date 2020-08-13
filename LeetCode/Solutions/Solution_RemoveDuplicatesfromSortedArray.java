
public class Solution_RemoveDuplicatesfromSortedArray {

	public static int removeDuplicates(int[] nums) {
		int len = nums.length, idx = 1;

		if (len == 0)
			return 0;

		int prev = nums[0];

		for (int i = 1; i < len; ++i) {
			if (prev != nums[i]) {
				nums[idx] = nums[i];
				prev = nums[i];
				++idx;
			}
		}

		return idx;
	}

	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[] { 1, 1, 2 }));
		System.out.println(removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }));
	}

}
