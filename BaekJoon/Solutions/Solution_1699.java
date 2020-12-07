import java.io.*;
import java.util.*;

public class Solution_1699 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int INF = 987654321;
        int[] dp = new int[N + 1];
        Arrays.fill(dp, INF);

        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= N; ++i) {
            for (int j = 1; i - (j * j) >= 0; ++j)
                dp[i] = Math.min(dp[i], dp[i - (j * j)] + 1);
        }

        bw.write(dp[N] + "");
        bw.flush();
        bw.flush();
        br.close();
    }
}
