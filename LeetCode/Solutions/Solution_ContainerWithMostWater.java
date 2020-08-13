
public class Solution_ContainerWithMostWater {

	public static int maxArea(int[] height) {
		int start = 0, end = height.length - 1;
		int max = 0;

		while (start < end) {
			int area = (end - start) * Math.min(height[start], height[end]);

			max = Math.max(max, area);

			if (height[start] <= height[end])
				start++;
			else
				end--;
		}

		return max;
	}

	public static void main(String[] args) {
		System.out.println(maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));

	}

}
