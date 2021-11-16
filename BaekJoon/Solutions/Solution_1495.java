import java.util.*;
import java.io.*;

public class Solution_1495 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        boolean[][] dp = new boolean[N + 1][M + 1];
        int[] volume = new int[N + 1];
        for (int i = 1; i <= N; ++i)
            volume[i] = Integer.parseInt(st.nextToken());

        dp[0][S] = true;
        int answer = 0;
        for (int i = 1; i <= N; ++i) {
            boolean flag = false;

            answer = 0;
            for (int j = 0; j <= M; ++j) {
                if (!dp[i - 1][j])
                    continue;

                for (int cur : new int[]{j - volume[i], j + volume[i]}) {
                    if (!(0 <= cur && cur <= M))
                        continue;

                    dp[i][cur] = true;
                    answer = Math.max(answer, cur);
                    flag = true;
                }
            }

            if (!flag) {
                answer = -1;
                break;
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
