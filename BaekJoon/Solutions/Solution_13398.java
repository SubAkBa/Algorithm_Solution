import java.util.*;
import java.io.*;

public class Solution_13398 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; ++i) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        dp[0][1] = nums[0];

        int answer = nums[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][1], Math.max(dp[i - 1][0] + nums[i], nums[i]));
            dp[i][1] = Math.max(dp[i - 1][1] + nums[i], nums[i]);

            answer = Math.max(answer, Math.max(dp[i][0], dp[i][1]));
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
