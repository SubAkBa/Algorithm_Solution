import java.io.*;

public class Solution_4811 {

    public static long DFS(long[][] dp, int one, int half) {
        if (one == 0)
            return dp[one][half] = 1;

        if (dp[one][half] != 0)
            return dp[one][half];

        dp[one][half] = DFS(dp, one - 1, half + 1);

        if (half > 0)
            dp[one][half] += DFS(dp, one, half - 1);

        return dp[one][half];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0)
                break;

            long[][] dp = new long[N + 1][N + 1];

            bw.write(DFS(dp, N, 0) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
