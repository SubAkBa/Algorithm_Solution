
public class Solution_JumpGame {

	public static boolean canJump(int[] nums) {
		int len = nums.length;

		if (len == 1)
			return true;

		int pos = len - 1;

		for (int i = len - 1; i >= 0; i--) {
			if (pos <= i + nums[i])
				pos = i;
		}

		return pos == 0;
	}

	public static void main(String[] args) {
		System.out.println(canJump(new int[] { 2, 3, 1, 1, 4 }));
		System.out.println(canJump(new int[] { 3, 2, 1, 0, 4 }));
		System.out.println(canJump(new int[] { 0 }));
		System.out.println(canJump(new int[] { 1, 0 }));
		System.out.println(canJump(new int[] { 4, 2, 0, 1, 1 }));
	}

}
