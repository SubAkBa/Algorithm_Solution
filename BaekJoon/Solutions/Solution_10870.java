import java.util.*;
import java.io.*;

public class Solution_10870 {

	public static int Fibonacci(int[] sum, int N) {
		if (N <= 1)
			return sum[N] = N;

		if (sum[N] != -1)
			return sum[N];

		return sum[N] = Fibonacci(sum, N - 1) + Fibonacci(sum, N - 2);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		int[] sum = new int[N + 1];

		Arrays.fill(sum, -1);

		Fibonacci(sum, N);

		bw.write(sum[N] + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
