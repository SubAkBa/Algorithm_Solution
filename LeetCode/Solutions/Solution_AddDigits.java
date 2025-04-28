public class Solution_AddDigits {
	public static int addDigits(int num) {
		int value = num;

		while (value / 10 > 0) {
			int sum = 0;

			while (value > 0) {
				sum += value % 10;
				value /= 10;
			}

			value = sum;
		}

		return value;
	}

	public static void main(String[] args) {
		System.out.println(addDigits(38)); // 2
		System.out.println(addDigits(0)); // 0
	}
}
