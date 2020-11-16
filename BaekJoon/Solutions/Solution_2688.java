import java.io.*;

public class Solution_2688 {
    static int MAX = 10;

    public static long DFS(long[][] dp, int len, int num) {
        if (len == 0)
            return 0;

        if (dp[len][num] != 0)
            return dp[len][num];

        for (int i = num; i < MAX; ++i)
            dp[len][num] += DFS(dp, len - 1, i);

        return dp[len][num];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        long[][] dp = new long[65][MAX];

        for (int i = 0; i < MAX; ++i)
            dp[1][i] = 1;

        while ((--T) >= 0) {
            int n = Integer.parseInt(br.readLine());

            long total = 0;

            for (int i = 0; i < MAX; ++i)
                total += DFS(dp, n, i);

            bw.write(total + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
