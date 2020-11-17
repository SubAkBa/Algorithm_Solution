import java.io.*;
import java.util.*;

public class Solution_1463 {
    static int INF = 987654321;

    public static int DFS(int[] dp, int N) {
        if (N == 1)
            return 0;

        if (dp[N] != INF)
            return dp[N];

        if (N % 3 == 0)
            dp[N] = Math.min(dp[N], DFS(dp, N / 3));

        if (N % 2 == 0)
            dp[N] = Math.min(dp[N], DFS(dp, N / 2));

        return dp[N] = Math.min(dp[N], DFS(dp, N - 1)) + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        Arrays.fill(dp, INF);

        dp[0] = dp[1] = 0;
        bw.write(DFS(dp, N) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
