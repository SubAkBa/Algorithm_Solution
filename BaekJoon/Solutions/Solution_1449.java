import java.io.*;
import java.util.*;

public class Solution_1449 {
	static int N, L;

	public static int Repairing(int[] pipe) {
		int count = 0;

		if (L == 1)
			return N;

		Stack<Integer> stack = new Stack<>();

		stack.push(pipe[0]);
		int prev = pipe[0];

		for (int i = 1; i < N; i++) {
			if ((pipe[i] - prev) <= (L - 1))
				stack.push(pipe[i]);
			else {
				prev = pipe[i];
				count++;

				while (!stack.isEmpty())
					stack.pop();

				stack.push(pipe[i]);
			}
		}

		if (!stack.isEmpty())
			count++;

		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] pipe = new int[N];

		for (int i = 0; i < N; i++)
			pipe[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(pipe);
		bw.write(Repairing(pipe) + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
