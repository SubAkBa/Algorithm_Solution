import java.util.*;

public class Solution_RemoveKDigits {

	public static String removeKdigits(String num, int k) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		int len = num.length(), n = len - k;

		if (len <= k)
			return "0";

		for (int i = 0; i < len; i++) {
			char c = num.charAt(i);

			while (k > 0 && !stack.isEmpty() && stack.peek() > c) {
				k--;
				stack.pop();
			}

			stack.push(c);

			if (stack.size() == 1 && stack.peek() == '0') {
				n--;
				stack.pop();
			}
		}

		if (stack.isEmpty())
			return "0";

		while (!stack.isEmpty())
			sb.append(stack.pop());

		return sb.reverse().substring(0, n);
	}

	public static void main(String[] args) {
		System.out.println(removeKdigits("1432219", 3)); // 1219
		System.out.println(removeKdigits("11111", 3)); // 11
		System.out.println(removeKdigits("10200", 1)); // 200
		System.out.println(removeKdigits("10", 2)); // 0
		System.out.println(removeKdigits("00000", 3)); // 0
		System.out.println(removeKdigits("112", 1)); // 11
	}
}
