import java.util.*;
import java.io.*;

public class Solution_1935 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		char[] ch = br.readLine().toCharArray();
		double[] nums = new double[N];

		for (int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(br.readLine());

		Stack<Double> stack = new Stack<>();
		double calc = 0;

		for (char c : ch) {
			switch (c) {
			case '+':
				calc = stack.pop() + stack.pop();
				stack.push(calc);
				break;
			case '-':
				calc = stack.pop();
				calc = stack.pop() - calc;
				stack.push(calc);
				break;
			case '*':
				calc = stack.pop() * stack.pop();
				stack.push(calc);
				break;
			case '/':
				calc = stack.pop();
				calc = stack.pop() / calc;
				stack.push(calc);
				break;
			default:
				stack.push(nums[c - 'A']);
			}
		}

		bw.write(String.format("%.2f", stack.pop()) + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
