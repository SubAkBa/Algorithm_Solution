import java.util.*;

public class Solution_PlusOne {
	public static int[] plusOne(int[] digits) {
		int len = digits.length;

		int plus = (digits[len - 1] + 1) / 10;
		digits[len - 1] = (digits[len - 1] + 1) % 10;

		for (int i = len - 2; i >= 0 && plus == 1; --i) {
			plus = (digits[i] + 1) / 10;
			digits[i] = (digits[i] + 1) % 10;
		}

		if (plus == 1) {
			int[] result = new int[digits.length + 1];
			result[0] = 1;
			System.arraycopy(digits, 0, result, 1, digits.length);
			
			return result;
		}

		return digits;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(plusOne(new int[] { 1, 2, 3 })));
		System.out.println(Arrays.toString(plusOne(new int[] { 4, 3, 2, 1 })));
		System.out.println(Arrays.toString(plusOne(new int[] { 1, 9, 9, 9, 9 })));
		System.out.println(Arrays.toString(plusOne(new int[] { 9, 9, 9, 9 })));
		System.out.println(Arrays.toString(plusOne(new int[] { 9, 9, 9, 8 })));
		System.out.println(Arrays.toString(plusOne(new int[] { 9, 9, 9, 0 })));
		System.out.println(Arrays.toString(plusOne(new int[] { 1, 2 })));
	}

}
