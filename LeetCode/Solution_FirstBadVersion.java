
public class Solution_FirstBadVersion {
	public static int firstBadVersion(int n) {
		int left = 1, right = n;

		while (left < right) {
			int mid = left + (right - left) / 2;

			if (!isBadVersion(mid))
				left = mid + 1;
			else
				right = mid;
		}

		return right;
	}

	public static void main(String[] args) {
		System.out.println(firstBadVersion(5));
	}

}
