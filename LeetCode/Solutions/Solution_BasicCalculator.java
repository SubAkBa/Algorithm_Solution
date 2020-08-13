import java.util.*;

public class Solution_BasicCalculator {

	public static int calculate(String s) {
		Stack<Integer> stack = new Stack<>();
		int cal = 0, oper = 1, len = s.length();

		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);

			switch (c) {
			case ' ':
				break;
			case '+':
				oper = 1;
				break;
			case '-':
				oper = -1;
				break;
			case '(':
				stack.push(cal);
				stack.push(oper);
				cal = 0;
				oper = 1;
				break;
			case ')':
				cal = cal * stack.pop() + stack.pop();
				break;
			default:
				int temp = c - '0';

				while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
					temp = temp * 10 + (s.charAt(i + 1) - '0');
					i++;
				}

				cal += temp * oper;
			}
		}

		return cal;
	}

	public static void main(String[] args) {
		System.out.println(calculate("1 + 1"));
		System.out.println(calculate(" 2-1 + 2 "));
		System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
		System.out.println(calculate("2147483647"));
		System.out.println(calculate("1-11"));
	}

}
