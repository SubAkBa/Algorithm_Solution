import java.util.*;

public class Solution_DifferentWaystoAddParentheses {

	public static List<Integer> diffWaysToCompute(String input) {
		List<Integer> answer = new ArrayList<>();
		int len = input.length();

		for (int i = 0; i < len; ++i) {
			if ('0' <= input.charAt(i) && input.charAt(i) <= '9')
				continue;

			List<Integer> left = diffWaysToCompute(input.substring(0, i));
			List<Integer> right = diffWaysToCompute(input.substring(i + 1));

			for (int l : left) {
				for (int r : right)
					answer.add(Calc(l, r, input.charAt(i)));
			}
		}

		if (answer.size() == 0)
			answer.add(Integer.parseInt(input));

		return answer;
	}

	public static int Calc(int left, int right, char oper) {
		int value = 0;

		switch (oper) {
		case '*':
			value = left * right;
			break;
		case '-':
			value = left - right;
			break;
		case '+':
			value = left + right;
			break;
		}

		return value;
	}

	public static void main(String[] args) {
		System.out.println(diffWaysToCompute("2-1-1")); // [0, 2]
		System.out.println(diffWaysToCompute("2*3-4*5")); // [-34, -14, -10, -10, 10]
	}
}
