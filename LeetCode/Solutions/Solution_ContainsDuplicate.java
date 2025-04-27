import java.util.HashSet;
import java.util.Set;

public class Solution_ContainsDuplicate {
	public static boolean containsDuplicate(int[] nums) {
		Set<Integer> numSet = new HashSet<>();

		for (int num : nums) {
			if (numSet.contains(num)) {
				return true;
			}

			numSet.add(num);
		}

		return false;
	}

	public static void main(String[] args) {
		System.out.println(containsDuplicate(new int[]{1,2,3,1})); // true
		System.out.println(containsDuplicate(new int[]{1,2,3,4})); // false
		System.out.println(containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2})); // true
	}
}
