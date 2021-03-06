import java.util.*;
import java.io.*;

public class Solution_17626 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        int INF = 97654321;

        Arrays.fill(dp, INF);

        for (int i = 1; i * i <= n; ++i)
            dp[i * i] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j * j <= i; ++j)
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
        }

        bw.write(dp[n] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
