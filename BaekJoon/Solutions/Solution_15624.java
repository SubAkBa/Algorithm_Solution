import java.io.*;

public class Solution_15624 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int MOD = 1000000007;

        int[] dp = new int[n + 2];

        dp[1] = 1;

        for (int i = 2; i <= n; ++i)
            dp[i] = (dp[i - 1] % MOD + dp[i - 2] % MOD) % MOD;

        bw.write(dp[n] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
