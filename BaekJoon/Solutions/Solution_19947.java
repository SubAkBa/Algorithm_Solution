import java.util.*;
import java.io.*;

public class Solution_19947 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int[] dp = new int[Y + 1];
        dp[0] = H;

        for (int i = 1; i <= Y; ++i) {
            dp[i] = (int) (dp[i - 1] * 1.05);

            if (i >= 3)
                dp[i] = Math.max(dp[i], (int) (dp[i - 3] * 1.2));

            if (i >= 5)
                dp[i] = Math.max(dp[i], (int) (dp[i - 5] * 1.35));
        }

        bw.write((int) dp[Y] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
