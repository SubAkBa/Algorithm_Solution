import java.util.*;
import java.io.*;

public class Solution_괄호짝짓기 {

	public static boolean isValid(char left, char right) {
		if (right == ']' && left != '[')
			return false;

		if (right == '}' && left != '{')
			return false;

		if (right == '>' && left != '<')
			return false;

		if (right == ')' && left != '(')
			return false;

		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = 10, tnum = 0;

		while ((--T) >= 0) {
			int len = Integer.parseInt(br.readLine());
			char[] parenthsises = br.readLine().toCharArray();
			Stack<Character> stack = new Stack<>();

			int answer = 1;
			for (char p : parenthsises) {
				if (p == '(' || p == '[' || p == '{' || p == '<')
					stack.push(p);
				else {
					if (stack.isEmpty() || !isValid(stack.peek(), p)) {
						answer = 0;
						break;
					}

					stack.pop();
				}
			}

			bw.write("#" + (++tnum) + " " + answer + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
