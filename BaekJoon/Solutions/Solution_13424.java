import java.util.*;
import java.io.*;

public class Solution_13424 {

    public static void Floyd_Warshall(int N, int[][] graph) {
        for (int via = 1; via <= N; ++via) {
            for (int from = 1; from <= N; ++from) {
                for (int to = 1; to <= N; ++to) {
                    if (from == to)
                        continue;

                    if (graph[from][to] > graph[from][via] + graph[via][to])
                        graph[from][to] = graph[from][via] + graph[via][to];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int INF = 987654321;

        while ((--T) >= 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] graph = new int[N + 1][N + 1];

            for (int i = 1; i <= N; ++i)
                Arrays.fill(graph[i], INF);

            for (int i = 0; i < M; ++i) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                graph[a][b] = graph[b][a] = c;
            }

            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] friend = new int[K];
            for (int i = 0; i < K; ++i)
                friend[i] = Integer.parseInt(st.nextToken());

            Floyd_Warshall(N, graph);

            System.out.println(Arrays.toString(friend));
            for (int i = 1; i <= N; ++i)
                System.out.println(Arrays.toString(graph[i]));

            int min_dist = INF, room = 0;
            for (int i = 1; i <= N; ++i) {
                int total = 0;
                for (int j = 0; j < K; ++j) {
                    if (i == friend[j])
                        continue;

                    total += graph[i][friend[j]];
                }

                if (min_dist > total) {
                    room = i;
                    min_dist = total;
                }
            }

            bw.write(room + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
