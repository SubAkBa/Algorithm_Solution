import java.io.*;

public class Solution_8394 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n + 1];

        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; ++i)
            dp[i] = dp[i - 1] % 10 + dp[i - 2] % 10;

        bw.write(dp[n] % 10 + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
