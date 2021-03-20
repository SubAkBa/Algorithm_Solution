import java.util.*;
import java.io.*;

public class Solution_16195 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int R = 1000, MOD = 1000000009;
        long[][] dp = new long[R + 1][R + 1];

        dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][3] = 1;
        dp[3][2] = 2;

        for (int i = 4; i <= R; ++i) {
            for (int j = 1; j <= i; ++j)
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 2][j - 1] + dp[i - 3][j - 1]) % MOD;
        }

        while ((--T) >= 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            long sum = 0;
            for (int i = 1; i <= m; ++i)
                sum = (sum + dp[n][i]) % MOD;

            bw.write(sum + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
