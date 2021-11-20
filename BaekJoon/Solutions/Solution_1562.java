import java.util.*;
import java.io.*;

public class Solution_1562 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int MOD = 1000000000;
        int N = Integer.parseInt(br.readLine());

        int[][][] dp = new int[N + 1][10][1 << 10];
        int full = (1 << 10) - 1;

        for (int i = 1; i < 10; ++i)
            dp[1][i][1 << i] = 1;

        for (int i = 1; i <= N; ++i) {
            for (int j = 0; j < 10; ++j) {
                for (int k = 0; k <= full; ++k) {
                    if (j == 0)
                        dp[i][j][k | (1 << j)] = (dp[i][j][k | (1 << j)] + dp[i - 1][j + 1][k]) % MOD;
                    else if (j == 9)
                        dp[i][j][k | (1 << j)] = (dp[i][j][k | (1 << j)] + dp[i - 1][j - 1][k]) % MOD;
                    else
                        dp[i][j][k | (1 << j)] = (dp[i][j][k | (1 << j)] + (dp[i - 1][j - 1][k] + dp[i - 1][j + 1][k]) % MOD) % MOD;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < 10; ++i)
            answer = (answer + dp[N][i][full]) % MOD;

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
