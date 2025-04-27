import java.util.HashSet;
import java.util.Set;

public class Solution_ContainsDuplicateII {
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> numSet = new HashSet<>();

		if (k == 0) {
			return false;
		}

		int iter = Math.min(k, nums.length);
		for (int i = 0; i < iter; ++i) {
			if (numSet.contains(nums[i])) {
				return true;
			}

			numSet.add(nums[i]);
		}

		for (int i = iter; i < nums.length; ++i) {
			if (numSet.contains(nums[i])) {
				return true;
			}

			numSet.add(nums[i]);
			numSet.remove(nums[i - iter]);
		}

		return false;
	}

	public static void main(String[] args) {
		System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1}, 3)); // true
		System.out.println(containsNearbyDuplicate(new int[]{1,0,1,1}, 1)); // true
		System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2)); // false
		System.out.println(containsNearbyDuplicate(new int[]{1,2,3,4,5,6,7,8,9,10}, 15)); // false
	}
}
