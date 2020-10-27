
public class Solution_ReverseInteger {

	public static int reverse(int x) {
		boolean isMinus = false;

		if (x < 0) {
			isMinus = true;
			x *= -1;
		}

		long lvalue = 0;
		int ivalue = 0;

		while (x > 0) {
			lvalue = lvalue * 10 + x % 10;
			ivalue = ivalue * 10 + x % 10;

			x /= 10;
		}

		if (lvalue != ivalue)
			ivalue = 0;
        	else if (isMinus)
			ivalue *= -1;

		return ivalue;
	}

	public static void main(String[] args) {
		System.out.println(reverse(123)); // 321
		System.out.println(reverse(-123)); // -321
		System.out.println(reverse(120)); // 21
		System.out.println(reverse(0)); // 0
		System.out.println(reverse(1534236469)); // 0
	}
}
