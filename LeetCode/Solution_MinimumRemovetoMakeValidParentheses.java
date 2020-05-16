import java.util.*;

public class Solution_MinimumRemovetoMakeValidParentheses {

	public static String minRemoveToMakeValid(String s) {
		Stack<Integer> stack = new Stack<>();
		int len = s.length();
		char[] ch = s.toCharArray();

		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);

			switch (c) {
			case '(':
				stack.push(i);
				break;
			case ')':
				if (stack.isEmpty())
					ch[i] = ' ';
				else
					stack.pop();
				break;
			}
		}

		while (!stack.isEmpty())
			ch[stack.pop()] = ' ';

		return String.valueOf(ch).replaceAll(" ", "");
	}

	public static void main(String[] args) {
		System.out.println(minRemoveToMakeValid("lee(t(c)o)de)")); // "lee(t(co)de)", "lee(t(c)ode)", "lee(t(c)o)de"
		System.out.println(minRemoveToMakeValid("a)b(c)d")); // "ab(c)d"
		System.out.println(minRemoveToMakeValid("))((")); // ""
		System.out.println(minRemoveToMakeValid("(a(b(c)d)")); // "a(b(c)d)"
	}
}
