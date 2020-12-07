import java.io.*;

public class Solution_15990 {
    static int MOD = 1000000009, LEN = 100000;

    public static long Func(int n, long[][] dp, int num) {
        if (n < 0)
            return 0;

        if (n == num)
            return 1;

        if (dp[n][num] != 0)
            return dp[n][num];

        if (num == 1)
            dp[n][num] = (Func(n - 1, dp, 2) + Func(n - 1, dp, 3)) % MOD;

        if (num == 2)
            dp[n][num] = (Func(n - 2, dp, 1) + Func(n - 2, dp, 3)) % MOD;

        if (num == 3)
            dp[n][num] = (Func(n - 3, dp, 1) + Func(n - 3, dp, 2)) % MOD;

        return dp[n][num];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        long[][] dp = new long[LEN + 1][4];

        while ((--T) >= 0) {
            int n = Integer.parseInt(br.readLine());

            bw.write((Func(n, dp, 1) + Func(n, dp, 2) + Func(n, dp, 3)) % MOD + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
