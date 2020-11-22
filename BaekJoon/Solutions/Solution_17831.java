import java.io.*;
import java.util.*;

public class Solution_17831 {

    public static int Mentoring(int N, List<Integer>[] adj, int[][] dp, int[] power, int from, int mentoring) {
        if (dp[from][mentoring] != 0)
            return dp[from][mentoring];

        int p = 0;
        for (int to : adj[from])
            p += Mentoring(N, adj, dp, power, to, 0);

        int value = p;
        if (mentoring == 0) {
            for (int to : adj[from]) {
                int temp = p - Mentoring(N, adj, dp, power, to, 0)
                        + Mentoring(N, adj, dp, power, to, 1) + power[from] * power[to];
                value = Math.max(value, temp);
            }
        }

        return dp[from][mentoring] = value;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Integer>[] adj = new ArrayList[N + 1];
        int[][] dp = new int[N + 1][2];
        int[] power = new int[N + 1];

        for (int i = 1; i <= N; ++i)
            adj[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= N; ++i)
            adj[Integer.parseInt(st.nextToken())].add(i);

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; ++i)
            power[i] = Integer.parseInt(st.nextToken());

        bw.write(Mentoring(N, adj, dp, power, 1, 0) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
