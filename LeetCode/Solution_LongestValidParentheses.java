import java.util.*;

public class Solution_LongestValidParentheses {

	public static int longestValidParentheses(String s) {
		int answer = 0, len = s.length();
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);

		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);

			switch (c) {
			case '(':
				stack.push(i);
				break;
			case ')':
				stack.pop();

				if (stack.isEmpty())
					stack.push(i);
				else
					answer = Math.max(answer, i - stack.peek());
				break;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(longestValidParentheses("()")); // 2
		System.out.println(longestValidParentheses(")")); // 0
		System.out.println(longestValidParentheses("(()")); // 2
		System.out.println(longestValidParentheses(")()())")); // 4
		System.out.println(longestValidParentheses("()(()")); // 2
		System.out.println(longestValidParentheses("(())(())")); // 8
		System.out.println(longestValidParentheses("(()())")); // 6
	}

}
