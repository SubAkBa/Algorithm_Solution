import java.io.*;

public class Solution_15993 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int MOD = 1000000009, NUM = 100000;
        long[][] dp = new long[NUM + 1][3];
        dp[1][1] = dp[2][1] = dp[2][2] = 1;
        dp[3][1] = dp[3][2] = 2;

        for (int i = 4; i <= NUM; ++i) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 2][2] + dp[i - 3][2]) % MOD;
            dp[i][2] = (dp[i - 1][1] + dp[i - 2][1] + dp[i - 3][1]) % MOD;
        }


        while ((--T) >= 0) {
            int n = Integer.parseInt(br.readLine());

            bw.write(dp[n][1] + " " + dp[n][2] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
