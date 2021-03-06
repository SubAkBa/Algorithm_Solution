import java.util.*;
import java.io.*;

public class Solution_14916 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int INF = 987654321;
        int[] dp = new int[n + 1];

        Arrays.fill(dp, INF);

        if (n >= 2)
            dp[2] = 1;

        if (n >= 4)
            dp[4] = 2;

        if (n >= 5)
            dp[5] = 1;

        for (int i = 6; i <= n; ++i)
            dp[i] = Math.min(dp[i - 2], dp[i - 5]) + 1;

        bw.write((dp[n] == INF ? -1 : dp[n]) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
