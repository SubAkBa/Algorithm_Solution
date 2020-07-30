import java.util.*;

public class Solution_ValidParentheses {

	public static boolean isValid(String s) {
		char[] ch = s.toCharArray();
		Stack<Character> stack = new Stack<>();

		for (char c : ch) {
			if (c == '(' || c == '{' || c == '[')
				stack.push(c);
			else if (stack.isEmpty() && (c == ']' || c == '}' || c == ')'))
				return false;
			else if (!stack.isEmpty()) {
				char sc = stack.pop();

				if ((sc != '[' && c == ']') || (sc != '{' && c == '}') || (sc != '(' && c == ')'))
					return false;
			}
		}

		if (!stack.isEmpty())
			return false;

		return true;
	}

	public static void main(String[] args) {
		System.out.println(isValid("()"));
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("(]"));
		System.out.println(isValid("([)]"));
		System.out.println(isValid("{[]}"));
	}

}
