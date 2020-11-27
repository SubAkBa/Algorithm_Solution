import java.io.*;

public class Solution_15988 {
    static int MOD = 1000000009, LEN = 1000000;

    public static long DFS(long[] dp, int n) {
        if (n <= 0)
            return 0;

        if (n <= 2)
            return dp[n] = n;

        if (n == 3)
            return dp[n] = 4;

        if (dp[n] != 0)
            return dp[n];

        return dp[n] = (DFS(dp, n - 1) + DFS(dp, n - 2) + DFS(dp, n - 3)) % MOD;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[LEN + 1];

        DFS(dp, LEN);

        while ((--T) >= 0) {
            int n = Integer.parseInt(br.readLine());
            bw.write(dp[n] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
