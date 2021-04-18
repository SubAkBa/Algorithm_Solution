import java.util.*;
import java.io.*;

public class Solution_19542 {
    static int[] dist;
    static List<Integer>[] adj;
    static int N, D;

    public static int DFS(int here, int parent) {
        int max_d = 0;
        for (int node : adj[here]) {
            if (node != parent)
                max_d = Math.max(max_d, DFS(node, here) + 1);
        }

        dist[here] = max_d;
        return dist[here];
    }

    public static int Calc(int S) {
        int count = 0;

        for (int i = 1; i <= N; ++i) {
            if (i != S && dist[i] >= D)
                count += 2;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        dist = new int[N + 1];

        for (int i = 1; i <= N; ++i)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; ++i) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x].add(y);
            adj[y].add(x);
        }

        DFS(S, 0);

        bw.write(Calc(S) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
