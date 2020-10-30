import java.util.*;
import java.io.*;

public class Solution_11051 {
	static int MOD = 10007;

	public static int Binom(int[][] arr, int n, int k) {
		if (n == k || k == 0)
			return arr[n][k] = 1;

		if (arr[n][k] != 0)
			return arr[n][k];

		return arr[n][k] = (Binom(arr, n - 1, k) + Binom(arr, n - 1, k - 1)) % MOD;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N + 1][K + 1];

		bw.write(Binom(arr, N, K) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
