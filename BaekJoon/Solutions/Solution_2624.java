import java.util.*;
import java.io.*;

public class Solution_2624 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[][] coins = new int[k][2];
        for (int i = 0; i < k; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            coins[i][0] = p;
            coins[i][1] = n;
        }

        int[] dp = new int[T + 1];
        dp[0] = 1;
        for (int[] coin : coins) {
            for (int i = T; i >= 0; --i) {
                for (int j = 1; j <= coin[1] && j * coin[0] <= i; ++j)
                    dp[i] += dp[i - coin[0] * j];
            }
        }

        bw.write(dp[T] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
