import java.io.*;

public class Solution_15989 {
    static int RANGE = 10000;

    public static void Prepare(int[][] dp) {
        dp[1][0] = 1;
        dp[2][0] = dp[2][1] = 1;
        dp[3][0] = dp[3][1] = dp[3][2] = 1;

        for (int i = 4; i <= RANGE; ++i) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = dp[i - 2][0] + dp[i - 2][1];
            dp[i][2] = dp[i - 3][0] + dp[i - 3][1] + dp[i - 3][2];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[][] dp = new int[RANGE + 1][3];

        Prepare(dp);

        while ((--T) >= 0) {
            int n = Integer.parseInt(br.readLine());

            bw.write((dp[n][0] + dp[n][1] + dp[n][2]) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
