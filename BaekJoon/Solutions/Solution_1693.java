import java.util.*;
import java.io.*;

public class Solution_1693 {
    static int COLORS = 20;

    public static long DFS(int n, List<Integer>[] adj, long[][] dp, int from, int prev, int color) {
        if (dp[from][color] != Long.MAX_VALUE)
            return dp[from][color];

        dp[from][color] = color;
        for (int to : adj[from]) {
            if (to == prev)
                continue;

            long temp = Long.MAX_VALUE;
            for (int i = 1; i < COLORS; ++i) {
                if (color == i)
                    continue;

                temp = Math.min(temp, DFS(n, adj, dp, to, from, i));
            }

            dp[from][color] += temp;
        }

        return dp[from][color];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        List<Integer>[] adj = new ArrayList[n + 1];
        long[][] dp = new long[n + 1][COLORS];

        for (int i = 1; i <= n; ++i) {
            adj[i] = new ArrayList<>();
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }

        for (int i = 0; i < n - 1; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        long result = Long.MAX_VALUE;
        for (int i = 1; i < COLORS; ++i)
            result = Math.min(result, DFS(n, adj, dp, 1, 0, i));

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
