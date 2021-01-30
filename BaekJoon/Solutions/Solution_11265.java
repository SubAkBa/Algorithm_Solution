import java.util.*;
import java.io.*;

public class Solution_11265 {

    public static void Floyd_Warshall(int N, int[][] graph) {
        for (int via = 1; via <= N; ++via) {
            for (int from = 1; from <= N; ++from) {
                for (int to = 1; to <= N; ++to) {
                    if (graph[from][to] > graph[from][via] + graph[via][to])
                        graph[from][to] = graph[from][via] + graph[via][to];
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

        int[][] graph = new int[N + 1][N + 1];
        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; ++j)
                graph[i][j] = Integer.parseInt(st.nextToken());
        }

        Floyd_Warshall(N, graph);

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (graph[A][B] <= C)
                bw.write("Enjoy other party\n");
            else
                bw.write("Stay here\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
