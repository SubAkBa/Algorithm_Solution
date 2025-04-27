import java.util.ArrayList;
import java.util.List;

public class Solution_SummaryRanges {
	public static List<String> summaryRanges(int[] nums) {
		int left = 0, right = 0;
		int length = nums.length;
		List<String> result = new ArrayList<>();

		while (right < length) {
			while (right + 1 < length && nums[right] + 1 == nums[right + 1]) {
				++right;
			}

			if (left == right) {
				result.add(String.valueOf(nums[left]));
			} else {
				result.add(nums[left] + "->" + nums[right]);
			}

			++right;
			left = right;
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(summaryRanges(new int[]{0,1,2,4,5,7})); // ["0->2","4->5","7"]
		System.out.println(summaryRanges(new int[]{0,2,3,4,6,8,9})); // ["0","2->4","6","8->9"]
		System.out.println(summaryRanges(new int[]{0})); // ["0"]
		System.out.println(summaryRanges(new int[]{})); // []
	}
}
