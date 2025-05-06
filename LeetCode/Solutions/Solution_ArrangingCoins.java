public class Solution_ArrangingCoins {
	public static int arrangeCoins(int n) {
		int left = 0, right = n;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			long sum = (long)mid * (mid + 1) / 2;

			if (sum == n) {
				return mid;
			} else if (sum > n) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return right;
	}

	public static void main(String[] args) {
		System.out.println(arrangeCoins(5)); // 2
		System.out.println(arrangeCoins(8)); // 3
		System.out.println(arrangeCoins(1)); // 1
		System.out.println(arrangeCoins(2)); // 1
		System.out.println(arrangeCoins(1804289383)); // 60070
	}
}
