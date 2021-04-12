import java.util.*;
import java.io.*;

public class Solution_3584 {
    static int[] depth;
    static int[][] ac;
    static int N, MAX_D;
    static List<Integer>[] adj;

    public static void getTree(int here, int parent) {
        depth[here] = depth[parent] + 1;
        ac[here][0] = parent;

        for (int i = 1; i <= MAX_D; ++i)
            ac[here][i] = ac[ac[here][i - 1]][i - 1];

        for (int node : adj[here]) {
            if (node != parent)
                getTree(node, here);
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
            }

            lca = ac[a][0];
        }

        return lca;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while ((--T) >= 0) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = null;

            depth = new int[N + 1];
            MAX_D = (int) Math.floor(Math.log(N + 1) / Math.log(2));
            ac = new int[N + 1][MAX_D + 1];
            adj = new ArrayList[N + 1];
            int[] par = new int[N + 1];
            for (int i = 1; i <= N; ++i)
                adj[i] = new ArrayList<>();

            for (int i = 0; i < N - 1; ++i) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                adj[a].add(b);
                adj[b].add(a);
                par[b] = a;
            }

            int root = 0;
            for (int i = 1; i <= N; ++i) {
                if (par[i] == 0) {
                    root = i;
                    break;
                }
            }

            getTree(root, 0);

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write(LCA(a, b) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
