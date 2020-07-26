import java.util.*;

public class Solution_TrappingRainWater {

	public static int trap(int[] height) {
		int len = height.length, water = 0;
		int left = 0, right = len - 1;

		while (left < right) {
			int left_max = height[left];
			int right_max = height[right];

			if (left_max < right_max) {
				while (left < right && left_max >= height[++left])
					water += left_max - height[left];
			} else {
				while (left < right && right_max >= height[--right])
					water += right_max - height[right];
			}
		}

		return water;
	}

	public static int trap(int[] height) {
		int len = height.length, water = 0;
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < len; ++i) {
			while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
				int top = stack.pop();

				if (stack.isEmpty())
					break;

				int w = i - stack.peek() - 1;
				int h = Math.min(height[i], height[stack.peek()]) - height[top];

				water += w * h;
			}

			stack.push(i);
		}

		return water;
	}

	public static void main(String[] args) {
		System.out.println(trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 })); // 6
		System.out.println(trap(new int[] { 3, 2, 1, 2, 5, 4, 0, 7 })); // 10
		System.out.println(trap(new int[] { 5, 2, 1, 3, 4, 3, 0, 1 })); // 7
		System.out.println(trap(new int[] { 5, 4, 3, 2, 1, 0 })); // 0
		System.out.println(trap(new int[] { 5, 2, 1, 3, 4, 3, 0, 7 })); // 17
	}
}
