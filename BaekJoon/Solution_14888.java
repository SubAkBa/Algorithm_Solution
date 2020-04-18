import java.util.*;
import java.io.*;

public class Solution_14888 {
	static int[] nums;
	static long max = Long.MIN_VALUE, min = Long.MAX_VALUE;

	public static void Permutation(int n, String str, LinkedList<Character> operlist, boolean[] visited) {
		if (n == operlist.size()) {
			int idx = 0;
			long temp = nums[idx++];
			for (char oper : operlist) {
				switch (oper) {
				case '+':
					temp += nums[idx++];
					break;
				case '-':
					temp -= nums[idx++];
					break;
				case '*':
					temp *= nums[idx++];
					break;
				case '/':
					if (temp < 0)
						temp = ((temp * -1) / nums[idx++]) * -1;
					else
						temp /= nums[idx++];
					break;
				}
			}

			max = Math.max(temp, max);
			min = Math.min(temp, min);

			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i])
				continue;

			visited[i] = true;
			operlist.add(str.charAt(i));

			Permutation(n, str, operlist, visited);

			visited[i] = false;
			operlist.removeLast();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		char[] chr = { '+', '-', '*', '/' };
		for (int i = 0; i < 4; i++) {
			int count = Integer.parseInt(st.nextToken());
			for (int j = 0; j < count; j++)
				sb.append(chr[i]);
		}

		Permutation(N - 1, sb.toString(), new LinkedList<>(), new boolean[N - 1]);

		bw.write(max + "\n" + min);
		bw.flush();
		bw.close();
		br.close();
	}
}
