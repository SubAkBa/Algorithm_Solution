
public class Solution_immigration {

	public static long solution(int n, int[] times) {
		int len = times.length;

		long max = 0;
		for (int i = 0; i < len; ++i)
			max = Math.max(max, times[i]);

		long left = 1, right = max * n;

		while (left < right) {
			long mid = left + (right - left) / 2;

			long count = 0;
			for (int i = 0; i < len; ++i)
				count += (long) mid / times[i];

			if (count >= n)
				right = mid;
			else
				left = mid + 1;
		}

		return right;
	}

	public static void main(String[] args) {
		System.out.println(solution(6, new int[] { 7, 10 }));
	}
}
