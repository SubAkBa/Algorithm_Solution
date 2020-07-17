
public class Solution_RemoveElement {

	public static int removeElement(int[] nums, int val) {
		int len = nums.length, idx = 0;

		for (int i = 0; i < len; ++i) {
			if (nums[i] != val) {
				nums[idx] = nums[i];
				++idx;
			}
		}

		return idx;
	}

	public static void main(String[] args) {
		System.out.println(removeElement(new int[] { 3, 2, 2, 3 }, 3));
		System.out.println(removeElement(new int[] { 0, 1, 2, 2, 3, 0, 4, 2 }, 2));
	}

}
