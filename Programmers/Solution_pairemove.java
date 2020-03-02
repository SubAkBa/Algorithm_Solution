import java.util.*;

public class Solution_pairemove {

	public static int solution(String s) {
		int answer = 1;
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (stack.isEmpty())
				stack.push(s.charAt(i));
			else {
				if (stack.peek() == s.charAt(i))
					stack.pop();
				else
					stack.push(s.charAt(i));
			}
		}

		if (!stack.isEmpty())
			answer = 0;

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution("baabaa"));
		System.out.println(solution("cdcd"));

	}

}
