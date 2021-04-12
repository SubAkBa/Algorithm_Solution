import java.util.*;
import java.io.*;

public class Solution_1761 {
    static int[] depth, dist;
    static int[][] ac;
    static int MAX_D, N;
    static List<Element>[] adj;

    public static class Element {
        int idx, dist;

        public Element(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    public static void getTree(int here, int parent, int d) {
        depth[here] = depth[parent] + 1;
        dist[here] = d;
        ac[here][0] = parent;

        for (int i = 1; i <= MAX_D; ++i)
            ac[here][i] = ac[ac[here][i - 1]][i - 1];

        for (Element node : adj[here]) {
            if (node.idx != parent)
                getTree(node.idx, here, d + node.dist);
        }
    }

    public static int LCA(int a, int b) {
        if (depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (int i = MAX_D; i >= 0; --i) {
            if (depth[a] <= depth[ac[b][i]])
                b = ac[b][i];
        }

        int lca = a;

        if (a != b) {
            for (int i = MAX_D; i >= 0; --i) {
                if (ac[a][i] != ac[b][i]) {
                    a = ac[a][i];
                    b = ac[b][i];
                }

                lca = ac[a][i];
            }
        }

        return lca;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        MAX_D = (int) Math.floor(Math.log(N + 1) / Math.log(2));
        depth = new int[N + 1];
        dist = new int[N + 1];
        ac = new int[N + 1][MAX_D + 1];
        StringTokenizer st = null;

        adj = new ArrayList[N + 1];

        for (int i = 1; i <= N; ++i)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; ++i) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            adj[a].add(new Element(b, d));
            adj[b].add(new Element(a, d));
        }

        getTree(1, 0, 0);

        int M = Integer.parseInt(br.readLine());

        while ((--M) >= 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int lca = LCA(a, b);

            bw.write((dist[a] + dist[b] - 2 * dist[lca]) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
