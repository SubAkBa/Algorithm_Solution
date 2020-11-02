import java.util.*;
import java.io.*;

public class Solution_11060 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] jump = new int[N];
		for (int i = 0; i < N; ++i)
			jump[i] = Integer.parseInt(st.nextToken());

		int INF = 987654321;
		int[] dp = new int[N];
		Arrays.fill(dp, INF);
		dp[0] = 1;

		for (int i = 0; i < N; ++i) {
			if (dp[i] == 0)
				break;

			for (int j = 1; j <= jump[i]; ++j) {
				if (i + j >= N)
					break;

				dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
			}
		}

		bw.write((dp[N - 1] == INF ? -1 : dp[N - 1] - 1) + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
