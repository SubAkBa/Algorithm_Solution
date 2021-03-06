import java.io.*;

public class Solution_13301 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= N; ++i)
            dp[i] = dp[i - 1] + dp[i - 2];

        bw.write(2 * (dp[N] + dp[N - 1]) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
