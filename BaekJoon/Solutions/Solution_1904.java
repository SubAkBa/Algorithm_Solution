import java.io.*;

public class Solution_1904 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int MOD = 15746;

		int[] sum = new int[N + 2];

		sum[1] = 1;
		sum[2] = 2;
		for (int i = 3; i <= N; ++i)
			sum[i] = (sum[i - 1] + sum[i - 2]) % MOD;

		bw.write(sum[N] + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
