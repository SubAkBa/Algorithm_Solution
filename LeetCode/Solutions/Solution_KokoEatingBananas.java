
public class Solution_KokoEatingBananas {

	public static int minEatingSpeed(int[] piles, int H) {
		int left = 1, right = (int) 1e9;

		while (left < right) {
			int mid = left + (right - left) / 2;
			int hour = 0;

			for (int p : piles)
				hour += (p - 1) / mid + 1;

			if (hour <= H)
				right = mid;
			else
				left = mid + 1;

		}

		return right;
	}

	public static void main(String[] args) {
		System.out.println(minEatingSpeed(new int[] { 3, 6, 7, 11 }, 8));
		System.out.println(minEatingSpeed(new int[] { 30, 11, 23, 4, 20 }, 5));
		System.out.println(minEatingSpeed(new int[] { 30, 11, 23, 4, 20 }, 6));
	}

}
