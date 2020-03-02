import java.util.*;
import java.io.*;

public class stack_1918_solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Character> stack = new Stack<>();
		String formula = br.readLine();
		StringBuilder sb = new StringBuilder(formula.length());

		char c;

		for (int i = 0; i < formula.length(); i++) {

			switch (formula.charAt(i)) {
			case '(':
				stack.push(formula.charAt(i));
				break;
			case '*':
			case '/':
				while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/'))
					sb.append(stack.pop());
				stack.push(formula.charAt(i));
				break;
			case '+':
			case '-':
				while(!stack.isEmpty() && stack.peek() != '(')
					sb.append(stack.pop());
				stack.push(formula.charAt(i));
				break;
			case ')':
				while ((c = stack.pop()) != '(')
					sb.append(c);
				break;
			default:
				sb.append(formula.charAt(i));
			}

		}

		while (!stack.isEmpty())
			sb.append(stack.pop());

		System.out.println(sb.toString());

	}

}
