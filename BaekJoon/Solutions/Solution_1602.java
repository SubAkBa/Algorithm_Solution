import java.util.*;
import java.io.*;

public class Solution_1602 {
    static int INF = 987654321, multi = 1000;

    public static void Floyd_Warshall(int N, int[][] graph, int[][] graph2, int[] dog, int[] idx) {
        for (int i = 1; i <= N; ++i) {
            int via = idx[i] % multi;

            for (int from = 1; from <= N; ++from) {
                for (int to = 1; to <= N; ++to) {
                    if (graph[from][via] == INF || graph[via][to] == INF)
                        continue;

                    if (graph[from][to] > graph[from][via] + graph[via][to])
                        graph[from][to] = graph[from][via] + graph[via][to];

                    int max_torture = Math.max(Math.max(dog[from], dog[to]), dog[via]);
                    if (graph2[from][to] > graph[from][to] + max_torture)
                        graph2[from][to] = graph[from][to] + max_torture;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] dog = new int[N + 1];
        for (int i = 1; i <= N; ++i)
            dog[i] = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N + 1][N + 1];
        int[][] graph2 = new int[N + 1][N + 1];
        int[] idx = new int[N + 1];

        for (int i = 1; i <= N; ++i) {
            Arrays.fill(graph[i], INF);
            Arrays.fill(graph2[i], INF);
            idx[i] = multi * dog[i] + i;
        }

        Arrays.sort(idx, 1, N + 1);

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph[a][b] = graph[b][a] = d;
            graph2[a][b] = graph2[b][a] = d + Math.max(dog[a], dog[b]);
        }

        Floyd_Warshall(N, graph, graph2, dog, idx);

        while ((--Q) >= 0) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            bw.write((graph2[S][T] == INF ? -1 : graph2[S][T]) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
