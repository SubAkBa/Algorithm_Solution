import java.util.*;
import java.io.*;

public class Solution_2812 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Stack<Character> stack = new Stack<>();
		char[] ch = br.readLine().toCharArray();

		for (char c : ch) {
			if (stack.isEmpty())
				stack.push(c);
			else {
				while (!stack.isEmpty() && stack.peek() < c && (K--) > 0)
					stack.pop();

				stack.push(c);
			}
		}

		while ((K--) > 0)
			stack.pop();

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty())
			sb.append(stack.pop());

		bw.write(sb.reverse().toString() + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
