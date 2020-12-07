import java.util.*;
import java.io.*;

public class Solution_16194 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cost = new int[N + 1];

        for (int i = 1; i <= N; ++i)
            cost[i] = Integer.parseInt(st.nextToken());

        int INF = 987654321;
        int[] dp = new int[N + 1];
        Arrays.fill(dp, INF);

        dp[0] = 0;
        for (int i = 1; i <= N; ++i) {
            for (int j = 0; j <= i; ++j)
                dp[i] = Math.min(dp[i], dp[i - j] + cost[j]);
        }

        bw.write(dp[N] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
