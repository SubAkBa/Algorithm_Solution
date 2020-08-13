
public class Solution_Sqrt_x {

	public static int mySqrt(int x) {
		if (x == 0)
			return 0;

		int left = 1, right = x;

		while (left < right) {
			int mid = left + (right - left) / 2;

			if ((long) mid * mid > x)
				right = mid;
			else
				left = mid + 1;
		}

		return right - 1;
	}

	public static void main(String[] args) {
		System.out.println(mySqrt(4));
		System.out.println(mySqrt(8));
	}
}
