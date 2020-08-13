import java.util.*;

public class Solution_RemoveInvalidParentheses {
	static int len;
	static List<String> answer;

	public static void DFS(char[] ch, int idx, int count, int leftcount, int rightcount, StringBuilder sb) {
		if (count < 0)
			return;

		if (idx == len) {
			if (leftcount == 0 && rightcount == 0)
				answer.add(sb.toString());

			return;
		}

		int i = 0;
		switch (ch[idx]) {
		case '(':
			while ((idx + i) < len && ch[idx + i] == '(') {
				sb.append('(');
				i++;
			}

			DFS(ch, idx + i, count + i, leftcount, rightcount, sb);
			sb.delete(sb.length() - i, sb.length());

			if (leftcount > 0)
				DFS(ch, idx + 1, count, leftcount - 1, rightcount, sb);
			break;
		case ')':
			while ((idx + i) < len && ch[idx + i] == ')') {
				sb.append(')');
				i++;
			}

			DFS(ch, idx + i, count - i, leftcount, rightcount, sb);
			sb.delete(sb.length() - i, sb.length());

			if (rightcount > 0)
				DFS(ch, idx + 1, count, leftcount, rightcount - 1, sb);
			break;
		default:
			sb.append(ch[idx]);

			DFS(ch, idx + 1, count, leftcount, rightcount, sb);

			sb.deleteCharAt(sb.length() - 1);
		}
	}

	public static List<String> removeInvalidParentheses(String s) {
		answer = new ArrayList<>();
		len = s.length();
		int leftcount = 0, rightcount = 0;

		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);

			if (c == '(')
				leftcount++;
			else if (c == ')') {
				if (leftcount == 0)
					rightcount++;
				else
					leftcount--;
			}
		}

		if (leftcount == 0 && rightcount == 0) {
			answer.add(s);
			return answer;
		}

		DFS(s.toCharArray(), 0, 0, leftcount, rightcount, new StringBuilder());

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(removeInvalidParentheses("()())()"));
		System.out.println(removeInvalidParentheses("(a)())()"));
		System.out.println(removeInvalidParentheses(")("));
	}

}
