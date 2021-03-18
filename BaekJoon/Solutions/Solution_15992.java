import java.util.*;
import java.io.*;

public class Solution_15992 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int R = 1000, MOD = 1000000009;
        int[][] dp = new int[R + 1][R + 1];
        dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = 1;

        for (int i = 3; i <= R; ++i) {
            for (int j = 1; j <= i; ++j) {
                dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MOD;
                dp[i][j] = (dp[i][j] + dp[i - 2][j - 1]) % MOD;
                dp[i][j] = (dp[i][j] + dp[i - 3][j - 1]) % MOD;
            }
        }

        while ((--T) >= 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            bw.write(dp[n][m] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
