import java.util.*;
import java.io.*;

public class Solution_1106 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int INF = 987654321, LEN = 100;
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] hotel = new int[N][2];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());

            int cost = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            hotel[i][0] = cost;
            hotel[i][1] = count;
        }

        int[] dp = new int[C + LEN + 1];
        Arrays.fill(dp, INF);

        dp[0] = 0;
        for (int i = 0; i <= C + LEN; ++i) {
            for (int j = 0; j < N; ++j) {
                if (i < hotel[j][1])
                    continue;

                dp[i] = Math.min(dp[i], dp[i - hotel[j][1]] + hotel[j][0]);
            }
        }

        int answer = INF;
        for (int i = C; i <= C + LEN; ++i)
            answer = Math.min(answer, dp[i]);

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}