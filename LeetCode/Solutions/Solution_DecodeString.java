import java.util.*;

public class Solution_DecodeString {

	public static String decodeString(String s) {
		Stack<Integer> stack1 = new Stack<>();
		Stack<Character> stack2 = new Stack<>();
		StringBuilder sb = new StringBuilder();

		char[] ch = s.toCharArray();
		int len = s.length();

		int repeat = 0;
		for (int i = 0; i < len; ++i) {
			if ('0' <= ch[i] && ch[i] <= '9')
				repeat = repeat * 10 + (ch[i] - '0');
			else if (ch[i] == '[') {
				stack1.push(repeat);
				stack2.push(ch[i]);
				repeat = 0;
			} else if (ch[i] == ']') {
				StringBuilder temp = new StringBuilder();
				StringBuilder str = new StringBuilder();
				char c;
				while ((c = stack2.pop()) != '[')
					str.append(c);

				int temp_rep = stack1.pop();
				str = str.reverse();

				while ((--temp_rep) >= 0)
					temp.append(str);

				if (stack1.isEmpty())
					sb.append(temp);
				else {
					int tlen = temp.length();

					for (int j = 0; j < tlen; ++j)
						stack2.push(temp.charAt(j));
				}
			} else {
				if (stack1.isEmpty())
					sb.append(ch[i]);
				else
					stack2.push(ch[i]);
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(decodeString("3[a]2[bc]"));
		System.out.println(decodeString("3[a2[c]]"));
		System.out.println(decodeString("2[abc]3[cd]ef"));
		System.out.println(decodeString("abc3[cd]xyz"));
	}
}
