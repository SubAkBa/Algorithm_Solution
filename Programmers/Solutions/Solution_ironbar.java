import java.util.*;

public class Solution_ironbar {

	public static int solution(String arrangement) {
		int answer = 0;
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < arrangement.length(); i++) {
			switch(arrangement.charAt(i)) {
			case '(':
				stack.push(arrangement.charAt(i));
				break;
			case ')':
				if(arrangement.charAt(i - 1) == '(') {
					stack.pop();
					answer += stack.size();
				}
				else {
					answer += 1;
					stack.pop();
				}
				break;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution("()(((()())(())()))(())"));

	}

}
