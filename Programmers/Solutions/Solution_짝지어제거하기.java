import java.util.*;

public class Solution_짝지어제거하기 {

	// 스택 이용
	public static int solution(String s) {
		int answer = 1;
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (stack.isEmpty() || stack.peek() != s.charAt(i))
				stack.push(s.charAt(i));
			else
				stack.pop();
		}

		if (!stack.isEmpty())
			answer = 0;

		return answer;
	}

	// 스택 이용X
	public static int solution(String s) {
		int idx = -1, len = s.length();
		char[] ch = new char[len];

		for (int i = 0; i < len; ++i) {
			if (idx == -1 || ch[idx] != s.charAt(i))
				ch[++idx] = s.charAt(i);
			else
				--idx;
		}

		return (idx == -1 ? 1 : 0);
	}

	public static void main(String[] args) {
		System.out.println(solution("baabaa"));
		System.out.println(solution("cdcd"));
	}
}
