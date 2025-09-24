import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_3584 {
    static List<Integer>[] adjList;
    static int[][] up;
    static int[] depth, parent;
    static int size, N;

    public static int getSize(int N) {
        return 32 - Integer.numberOfLeadingZeros(N);
    }

    public static void build(int root) {
        Arrays.fill(depth, -1);

        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(root);
        depth[root] = 0;
        up[0][root] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : adjList[current]) {
                if (depth[next] != -1) {
                    continue;
                }

                queue.offer(next);
                depth[next] = depth[current] + 1;
                up[0][next] = current;
            }
        }

        for (int i = 1; i < size; ++i) {
            for (int j = 1; j <= N; ++j) {
                up[i][j] = up[i - 1][up[i - 1][j]];
            }
        }
    }

    public static int lift(int node, int dist) {
        while (node != 0 && dist != 0) {
            int i = Integer.numberOfTrailingZeros(dist);
            node = up[i][node];
            dist &= dist - 1;
        }

        return node;
    }

    public static int lca(int a, int b) {
        if (depth[a] > depth[b]) {
            a = lift(a, depth[a] - depth[b]);
        } else if (depth[a] < depth[b]) {
            b = lift(b, depth[b] - depth[a]);
        }

        if (a == b) {
            return a;
        }

        for (int i = size - 1; i >= 0; --i) {
            if (up[i][a] != up[i][b]) {
                a = up[i][a];
                b = up[i][b];
            }
        }

        return up[0][a];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while ((--T) >= 0) {
            N = Integer.parseInt(br.readLine());
            size = getSize(N);
            adjList = new ArrayList[N + 1];
            up = new int[size][N + 1];
            depth = new int[N + 1];
            parent = new int[N + 1];

            for (int i = 1; i <= N; ++i) {
                adjList[i] = new ArrayList<>();
            }

            for (int i = 0; i < N - 1; ++i) {
                st = new StringTokenizer(br.readLine());

                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                adjList[A].add(B);
                adjList[B].add(A);
                parent[B] = A;
            }

            int root = -1;
            for (int i = 1; i <= N; ++i) {
                if (parent[i] == 0) {
                    root = i;
                    break;
                }
            }

            build(root);

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(lca(a, b)).append("\n");
        }

        System.out.println(sb);
    }
}
