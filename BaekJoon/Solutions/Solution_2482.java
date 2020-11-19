import java.io.*;
import java.util.Arrays;

public class Solution_2482 {
    static int MOD = 1000000003;

    public static int DFS(int N, int K, int[][] dp) {
        if (N <= 0 || N < K * 2)
            return 0;

        if (K == 1)
            return N;

        if (dp[N][K] != 0)
            return dp[N][K];

        return dp[N][K] = (DFS(N - 2, K - 1, dp) + DFS(N - 1, K, dp)) % MOD;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][K + 1];

        bw.write(DFS(N, K, dp) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
