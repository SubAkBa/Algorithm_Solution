import java.io.*;
import java.util.*;

public class Solution_13265 {
    static int n, m;
    static List<Integer>[] adj;
    static int[] flags;

    public static boolean DFS(int prev, int current) {
        boolean result = true;

        for (int next : adj[current]) {
            if (prev == next)
                continue;

            if (flags[next] != 0) {
                if (flags[next] == flags[current])
                    return false;

                continue;
            }

            flags[next] = flags[current] * -1;
            result &= DFS(current, next);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while ((--T) >= 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            adj = new ArrayList[n + 1];

            for (int i = 1; i <= n; ++i)
                adj[i] = new ArrayList<>();

            flags = new int[n + 1];

            for (int i = 0; i < m; ++i) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                adj[x].add(y);
                adj[y].add(x);
            }

            boolean result = true;

            for (int i = 1; i <= n && result; ++i) {
                if (flags[i] == 0) {
                    flags[i] = -1;
                    result = DFS(0, i);
                }
            }

            bw.write(result ? "possible\n" : "impossible\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
