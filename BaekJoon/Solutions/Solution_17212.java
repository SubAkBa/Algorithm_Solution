import java.util.*;
import java.io.*;

public class Solution_17212 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] coins = new int[]{1, 2, 5, 7};

        int N = Integer.parseInt(br.readLine());
        int INF = 987654321;
        int[] dp = new int[N + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i <= N; ++i) {
            for (int j = 0; j < 4; ++j) {
                if (coins[j] > i)
                    break;

                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }

        bw.write(dp[N] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
