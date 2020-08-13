import java.util.*;

public class Solution_KClosestPointstoOrigin {

	public static double GetDist(int[] p1) {
		return Math.sqrt(p1[0] * p1[0] + p1[1] * p1[1]);
	}

	public static int[][] kClosest(int[][] points, int K) {
		int left = 0, right = points.length - 1;

		while (left <= right) {
			int mid = Sort(points, left, right);

			if (mid == K)
				break;
			else if (mid < K)
				left = mid + 1;
			else
				right = mid - 1;
		}

		return Arrays.copyOfRange(points, 0, K);
	}

	public static int Sort(int[][] points, int left, int right) {
		int[] pivot = points[left];

		while (left < right) {
			while (left < right && Double.compare(GetDist(pivot), GetDist(points[right])) <= 0)
				--right;

			points[left] = points[right];

			while (left < right && Double.compare(GetDist(pivot), GetDist(points[left])) >= 0)
				++left;

			points[right] = points[left];
		}

		points[left] = pivot;

		return right;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(kClosest(new int[][] { { 1, 3 }, { -2, 2 } }, 1)));
		System.out.println(Arrays.deepToString(kClosest(new int[][] { { 3, 3 }, { 5, -1 }, { -2, 4 } }, 2)));
		System.out.println(Arrays.deepToString(kClosest(new int[][] { { -5, 4 }, { -6, -5 }, { 4, 6 } }, 2))); // [[-5,4],[4,6]]
	}
}
