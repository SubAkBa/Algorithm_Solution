import java.util.*;
import java.io.*;

public class Solution_11438 {
    static int MAX, MAX_N, N;
    static int[] depth;
    static int[][] ac;
    static List<Integer>[] adj;

    public static void getTree(int here, int parent) {
        depth[here] = depth[parent] + 1;
        ac[here][0] = parent;

        for (int i = 1; i <= MAX; ++i)
            ac[here][i] = ac[ac[here][i - 1]][i - 1];

        for (int node : adj[here]) {
            if (node != parent)
                getTree(node, here);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        MAX = (int) Math.floor(Math.log(N) / Math.log(2));
        MAX_N = 100000;
        depth = new int[MAX_N + 1];
        ac = new int[MAX_N + 1][20];

        depth[0] = -1;
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; ++i)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            adj[A].add(B);
            adj[B].add(A);
        }

        getTree(1, 0);

        int M = Integer.parseInt(br.readLine());

        while ((--M) >= 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (depth[a] != depth[b]) {
                if (depth[a] > depth[b]) {
                    int temp = a;
                    a = b;
                    b = temp;
                }

                for (int i = MAX; i >= 0; --i) {
                    if (depth[a] <= depth[ac[b][i]])
                        b = ac[b][i];
                }
            }

            int lca = a;

            if (a != b) {
                for (int i = MAX; i >= 0; --i) {
                    if (ac[a][i] != ac[b][i]) {
                        a = ac[a][i];
                        b = ac[b][i];
                    }

                    lca = ac[a][i];
                }
            }

            bw.write(lca + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
