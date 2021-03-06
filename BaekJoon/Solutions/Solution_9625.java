import java.io.*;

public class Solution_9625 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int K = Integer.parseInt(br.readLine());
        int[] dp = new int[K + 1];

        dp[1] = 1;

        for (int i = 2; i <= K; ++i)
            dp[i] = dp[i - 1] + dp[i - 2];

        bw.write(dp[K - 1] + " " + dp[K]);
        bw.flush();
        bw.close();
        br.close();
    }
}
