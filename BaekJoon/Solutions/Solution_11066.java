import java.util.*;
import java.io.*;

public class Solution_11066 {
    static int INF = 987654321;

    public static int DFS(int[] file, int[] sum, int[][] dp, int left, int right) {
        if (dp[left][right] != INF)
            return dp[left][right];

        if (left == right)
            return dp[left][right] = 0;

        for (int mid = left; mid < right; ++mid)
            dp[left][right] = Math.min(dp[left][right],
                    DFS(file, sum, dp, left, mid) + DFS(file, sum, dp, mid + 1, right));

        return dp[left][right] += sum[right] - sum[left - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while ((--T) >= 0) {
            int K = Integer.parseInt(br.readLine());

            int[] file = new int[K + 1], sum = new int[K + 1];
            int[][] dp = new int[K + 1][K + 1];

            for (int i = 0; i <= K; ++i)
                Arrays.fill(dp[i], INF);

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= K; ++i) {
                file[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + file[i];
            }

            bw.write(DFS(file, sum, dp, 1, K) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
