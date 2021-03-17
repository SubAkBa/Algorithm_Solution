import java.util.*;
import java.io.*;

public class Solution_2780 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int NUM = 10, RANGE = 1000, MOD = 1234567;
        long[][] dp = new long[RANGE + 1][NUM];
        Arrays.fill(dp[1], 1);

        for (int i = 2; i <= RANGE; ++i) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][3]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2] + dp[i - 1][4]) % MOD;
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][5]) % MOD;
            dp[i][3] = (dp[i - 1][0] + dp[i - 1][4] + dp[i - 1][6]) % MOD;
            dp[i][4] = (dp[i - 1][1] + dp[i - 1][3] + dp[i - 1][5] + dp[i - 1][7]) % MOD;
            dp[i][5] = (dp[i - 1][2] + dp[i - 1][4] + dp[i - 1][8]) % MOD;
            dp[i][6] = (dp[i - 1][3] + dp[i - 1][7] + dp[i - 1][9]) % MOD;
            dp[i][7] = (dp[i - 1][4] + dp[i - 1][6] + dp[i - 1][8]) % MOD;
            dp[i][8] = (dp[i - 1][5] + dp[i - 1][7]) % MOD;
            dp[i][9] = dp[i - 1][6];
        }

        while ((--T) >= 0) {
            int N = Integer.parseInt(br.readLine());

            int sum = 0;
            for (int i = 0; i < NUM; ++i)
                sum += dp[N][i];

            bw.write(sum % MOD + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
