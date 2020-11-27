import java.util.*;
import java.io.*;

public class Solution_12852 {
    static int INF = 987654321;

    public static int DFS(int[] dp, int[] before, int N) {
        if (N == 1)
            return 0;

        if (dp[N] != INF)
            return dp[N];

        if (N % 3 == 0) {
            int temp = DFS(dp, before, N / 3) + 1;

            if (dp[N] > temp) {
                dp[N] = temp;
                before[N] = N / 3;
            }
        }

        if ((N & 1) == 0) {
            int temp = DFS(dp, before, N / 2) + 1;

            if (dp[N] > temp) {
                dp[N] = temp;
                before[N] = N / 2;
            }
        }

        int temp = DFS(dp, before, N - 1) + 1;

        if (dp[N] > temp) {
            dp[N] = temp;
            before[N] = N - 1;
        }

        return dp[N];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int[] before = new int[N + 1];

        Arrays.fill(dp, INF);

        bw.write(DFS(dp, before, N) + "\n" + N);

        for (int i = before[N]; i != 0; i = before[i])
            bw.write(" " + i);

        bw.flush();
        bw.close();
        br.close();
    }
}
