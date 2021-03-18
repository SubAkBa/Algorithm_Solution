import java.io.*;

public class Solution_15991 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int R = 100000, MOD = 1000000009;
        long[] dp = new long[R + 1];
        dp[1] = 1;
        dp[2] = dp[3] = 2;
        dp[4] = dp[5] = 3;
        dp[6] = 6;

        for (int i = 7; i <= R; ++i) {
            dp[i] = (dp[i - 2] + dp[i - 4] + dp[i - 6]) % MOD;
        }

        while ((--T) >= 0) {
            int n = Integer.parseInt(br.readLine());

            bw.write(dp[n] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
