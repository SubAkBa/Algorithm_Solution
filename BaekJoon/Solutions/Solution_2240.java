import java.util.*;
import java.io.*;

public class Solution_2240 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] pos = new int[T + 1];
        int[][][] dp = new int[3][W + 1][T + 1];

        for (int i = 1; i <= T; ++i)
            pos[i] = Integer.parseInt(br.readLine());

        if (pos[0] == 1)
            dp[1][0][1] = 1;
        else
            dp[2][1][1] = 1;

        for (int i = 1; i <= T; ++i) {
            for (int j = 0; j <= W; ++j) {
                if (pos[i] == 1) {
                    if (j == 0) {
                        dp[1][j][i] = dp[1][j][i - 1] + 1;
                        continue;
                    }

                    dp[1][j][i] = Math.max(dp[1][j][i - 1], dp[2][j - 1][i - 1]) + 1;
                    dp[2][j][i] = Math.max(dp[1][j - 1][i - 1], dp[2][j][i - 1]);
                } else {
                    if (j == 0) {
                        dp[1][j][i] = dp[1][j][i - 1];
                        continue;
                    }

                    dp[1][j][i] = Math.max(dp[1][j][i - 1], dp[2][j - 1][i - 1]);
                    dp[2][j][i] = Math.max(dp[1][j - 1][i - 1], dp[2][j][i - 1]) + 1;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i <= W; ++i)
            answer = Math.max(answer, Math.max(dp[1][i][T], dp[2][i][T]));

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
