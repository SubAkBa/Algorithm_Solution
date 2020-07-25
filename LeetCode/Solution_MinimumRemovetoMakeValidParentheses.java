
public class Solution_MinimumRemovetoMakeValidParentheses {

	// 짝이 맞지 않는 괄호를 빈칸 ' '으로 수정
	public String minRemoveToMakeValid(String s) {
		char[] ch = s.toCharArray();
		Stack<Integer> stack = new Stack<>();
		int len = s.length();

		for (int i = 0; i < len; ++i) {
			switch (ch[i]) {
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

	// 짝이 맞는 괄호 쌍을 open으로 판단하여 추후 제거
	public String minRemoveToMakeValid(String s) {
		char[] ch = s.toCharArray();
		int open = 0;
		StringBuilder sb = new StringBuilder();

		for (char c : ch) {
			switch (c) {
			case '(':
				++open;
				break;
			case ')':
				if (open == 0)
					continue;

				--open;
				break;
			}

			sb.append(c);
		}

		int sblen = sb.length();

		for (int i = sblen - 1; i >= 0; --i) {
			char c = sb.charAt(i);
			if (c == '(' && (--open) >= 0)
				sb.deleteCharAt(i);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
		System.out.println(minRemoveToMakeValid("a)b(c)d"));
		System.out.println(minRemoveToMakeValid("))(("));
		System.out.println(minRemoveToMakeValid("(a(b(c)d)"));
	}
}
