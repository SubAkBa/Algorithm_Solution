
public class Solution_IntegerBreak {

	public static int integerBreak(int n) {
		int[] sum = new int[n + 1];

		sum[1] = 0;
		for (int i = 2; i <= n; ++i) {
			for (int j = 1; j < i; ++j)
				sum[i] = Math.max(sum[i], Math.max(j, sum[j]) * Math.max(i - j, sum[i - j]));
		}

		return sum[n];
	}

	public static int integerBreak(int n) {
		if (n == 2)
			return 1;
		else if (n == 3)
			return 2;

		int r = n % 3;
		int q = n / 3;

		if (r == 0)
			return (int) Math.pow(3, q);
		else if (r == 1)
			return (int) Math.pow(3, q - 1) * 4;
		else
			return (int) Math.pow(3, q - 1) * 2;
	}

	public static void main(String[] args) {
		System.out.println(integerBreak(2)); // 1
		System.out.println(integerBreak(10)); // 36
	}
}
