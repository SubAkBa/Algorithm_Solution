import java.io.*;
import java.util.*;

public class Solution_14938 {
    static int INF = 987654321;

    public static void Floyd_Warshall(int n, int[][] graph) {
        for (int via = 1; via <= n; ++via) {
            for (int from = 1; from <= n; ++from) {
                for (int to = 1; to <= n; ++to) {
                    if (from == to)
                        continue;

                    if (graph[from][to] > graph[from][via] + graph[via][to])
                        graph[from][to] = graph[from][via] + graph[via][to];
                }
            }
        }
    }

    public static class Edge {
        int idx, dist;

        public Edge(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n + 1][n + 1];

        st = new StringTokenizer(br.readLine());
        int[] item = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            item[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(graph[i], INF);
        }

        for (int i = 0; i < r; ++i) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            if (graph[a][b] == 0 || graph[a][b] > l)
                graph[a][b] = graph[b][a] = l;
        }

        Floyd_Warshall(n, graph);

        int max_item = 0;
        for (int i = 1; i <= n; ++i) {
            int total = item[i];

            for (int j = 1; j <= n; ++j) {
                if (graph[i][j] != INF && graph[i][j] <= m)
                    total += item[j];
            }

            max_item = Math.max(max_item, total);
        }

        bw.write(max_item + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
