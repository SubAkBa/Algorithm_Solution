import java.util.*;
import java.io.*;

public class Solution_4949 {

	public static String ValidParenthesis(char[] ch) {
		Stack<Character> stack = new Stack<>();

		for (char c : ch) {
			if (c == '(' || c == '[')
				stack.push(c);
			else if (c == ')') {
				if (!stack.isEmpty() && stack.peek() == '(')
					stack.pop();
				else
					return "no";
			} else if (c == ']') {
				if (!stack.isEmpty() && stack.peek() == '[')
					stack.pop();
				else
					return "no";
			}
		}

		if (!stack.isEmpty())
			return "no";

		return "yes";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			char[] ch = br.readLine().toCharArray();

			if (ch.length == 1 && ch[0] == '.')
				break;

			bw.write(ValidParenthesis(ch) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
