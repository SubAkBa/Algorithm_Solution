import java.util.*;
import java.io.*;

public class Solution_2748 {

	public static long Fibonacci(long[] sum, int n) {
		if (n <= 0)
			return 0;

		if (n == 1)
			return sum[n] = 1;

		if (sum[n] != -1)
			return sum[n];

		return sum[n] = Fibonacci(sum, n - 1) + Fibonacci(sum, n - 2);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());

		long[] sum = new long[n + 1];

		Arrays.fill(sum, -1);

		sum[0] = 0;
		Fibonacci(sum, n);

		bw.write(sum[n] + "");
		bw.close();
		br.close();
	}
}
