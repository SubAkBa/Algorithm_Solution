import java.io.*;
import java.util.*;

public class Solution_1535 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[][] person = new int[N + 1][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; ++i)
            person[i][0] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; ++i)
            person[i][1] = Integer.parseInt(st.nextToken());

        int HP = 99;
        int[][] dp = new int[N + 1][HP + 1];
        for (int i = 1; i <= N; ++i) {
            for (int j = 0; j <= HP; ++j) {
                dp[i][j] = dp[i - 1][j];

                if (j >= person[i][0])
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - person[i][0]] + person[i][1]);
            }
        }

        bw.write(dp[N][HP] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
