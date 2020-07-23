import java.util.*;

public class Solution_MinimumNumberofArrowstoBurstBalloons {

	public static int findMinArrowShots(int[][] points) {
		int len = points.length;

		if (len <= 1)
			return len;

		Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

		int count = 0;
		int end = points[0][1];

		for (int i = 1; i < len; ++i) {
            if(points[i][0] <= end)
                continue;
            
            end = points[i][1];
            ++count;
		}

		if (points[len - 1][0] <= end)
			++count;

		return count;
	}
	public static void main(String[] args) {
		System.out.println(findMinArrowShots(new int[][] { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } })); // 2
		System.out.println(findMinArrowShots(
				new int[][] { { 9, 12 }, { 1, 10 }, { 4, 11 }, { 8, 12 }, { 3, 9 }, { 6, 9 }, { 6, 7 } })); // 2
		System.out.println(findMinArrowShots(new int[][] { { 1, 2 }, { 2, 3 }, { 2, 5 }, { 5, 6 } })); // 2
	}

}
