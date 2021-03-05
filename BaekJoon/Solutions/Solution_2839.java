import java.util.*;
import java.io.*;

public class Solution_2839 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int INF = 987654321;

        int[] dp = new int[N + 1];

        Arrays.fill(dp, INF);

        dp[3] = 1;

        if (N >= 5)
            dp[5] = 1;

        for (int i = 6; i <= N; ++i) {
            if (dp[i - 3] == INF && dp[i - 5] == INF)
                continue;

            dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
        }

        int result = dp[N];
        if (dp[N] == INF)
            result = -1;

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
