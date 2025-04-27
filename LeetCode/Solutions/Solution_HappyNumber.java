import java.util.HashSet;
import java.util.Set;

public class Solution_HappyNumber {
	public static boolean isHappy(int n) {
		int value = n, sum = 0;
		boolean result = false;
		Set<Integer> numSet = new HashSet<>();

		while (true) {
			while (value > 0) {
				int remainder = value % 10;

				sum += remainder * remainder;

				value /= 10;
			}

			if (sum == 1) {
				result = true;
				break;
			} else if (numSet.contains(sum)) {
				break;
			}

			numSet.add(sum);

			value = sum;
			sum = 0;
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(isHappy(19)); // true
		System.out.println(isHappy(2)); // false
		System.out.println(isHappy(1)); // true
		System.out.println(isHappy(3)); // false
	}
}
