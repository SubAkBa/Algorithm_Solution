import java.util.*;

public class Solution_makelargenumber {

	public static String solution(String number, int k) {
		Stack<Character> stack = new Stack<>();
		int n = number.length() - k;

		for (int i = 0; i < number.length(); i++) {
			if (stack.isEmpty())
				stack.push(number.charAt(i));
			else {
				if (stack.peek() >= number.charAt(i))
					stack.push(number.charAt(i));
				else {
					while (k > 0 && !stack.isEmpty() && stack.peek() < number.charAt(i)) {
						stack.pop();
						k--;
					}
					stack.push(number.charAt(i));
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		while(!stack.isEmpty())
			sb.append(stack.pop());

		return sb.reverse().substring(0, n).toString();
	}

	public static void main(String[] args) {
		System.out.println(solution("1924", 2));
		System.out.println(solution("1231234", 3));
		System.out.println(solution("4177252841", 4));
		System.out.println(solution("0000000000", 5));
		System.out.println(solution("9876543210", 5));
	}

}
