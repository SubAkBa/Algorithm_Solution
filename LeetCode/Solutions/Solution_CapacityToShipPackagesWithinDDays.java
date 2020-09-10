
public class Solution_CapacityToShipPackagesWithinDDays {

	public static int shipWithinDays(int[] weights, int D) {
		int len = weights.length;

		int right = 0, max_weight = 0;

		for (int i = 0; i < len; ++i) {
			right += weights[i];
			max_weight = Math.max(max_weight, weights[i]);
		}

		if (len == 1)
			return weights[0];
		else if (D == len)
			return max_weight;

		int left = 0;

		while (left < right) {
			int mid = left + (right - left) / 2;

			boolean flag = false;
			int day = 1, total = 0;
			for (int i = 0; i < len; ++i) {
				if (mid < weights[i]) {
					flag = true;
					break;
				}

				if (total + weights[i] <= mid)
					total += weights[i];
				else {
					total = weights[i];
					++day;
				}
			}

			if (day > D || flag)
				left = mid + 1;
			else if (day <= D)
				right = mid;
		}

		return right;
	}

	public static void main(String[] args) {
		System.out.println(shipWithinDays(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 5)); // 15
		System.out.println(shipWithinDays(new int[] { 3, 2, 2, 4, 1, 4 }, 3)); // 6
		System.out.println(shipWithinDays(new int[] { 1, 2, 3, 1, 1 }, 4)); // 3
	}
}
