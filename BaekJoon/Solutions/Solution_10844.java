import java.io.*;

public class Solution_10844 {
    static int LEN = 10, MOD = 1000000000;

    public static long Func(int N, long[][] dp, int num) {
        if (N == 0)
            return 1;

        if (dp[N][num] != 0)
            return dp[N][num];

        if(num == 0)
            dp[N][num] = Func(N - 1, dp, num + 1);
        else if(num == 9)
            dp[N][num] = Func(N - 1, dp, num - 1);
        else
            dp[N][num] = (Func(N - 1, dp, num + 1) + Func(N - 1, dp, num - 1)) % MOD;

        return dp[N][num];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N][LEN];

        long total = 0;
        for (int i = 1; i < LEN; ++i)
            total = (total + Func(N - 1, dp, i)) % MOD;

        bw.write(total + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
