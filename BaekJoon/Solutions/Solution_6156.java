import java.util.*;
import java.io.*;

public class Solution_6156 {

    public static void Floyd_Warshall(int N, boolean[][] graph) {
        for (int via = 1; via <= N; ++via) {
            for (int from = 1; from <= N; ++from) {
                for (int to = 1; to <= N; ++to) {
                    if (graph[from][via] && graph[via][to])
                        graph[from][to] = true;
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

        boolean[][] graph = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[A][B] = true;
        }

        Floyd_Warshall(N, graph);

        int total = 0;
        for (int i = 1; i <= N; ++i) {
            int count = 0;
            for (int j = 1; j <= N; ++j) {
                if (graph[i][j] || graph[j][i])
                    ++count;
            }

            if (count == N - 1)
                ++total;
        }

        bw.write(total + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
