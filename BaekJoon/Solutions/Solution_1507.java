import java.util.*;
import java.io.*;

public class Solution_1507 {
    static int result;

    public static void Floyd_Warshall(int N, int[][] graph, boolean[][] road) {
        for (int via = 1; via <= N; ++via) {
            for (int from = 1; from <= N; ++from) {
                for (int to = 1; to <= N; ++to) {
                    if (from == to || from == via || via == to)
                        continue;

                    if (graph[from][to] > graph[from][via] + graph[via][to]) {
                        result = -1;
                        return;
                    } else if (graph[from][to] == graph[from][via] + graph[via][to])
                        road[from][to] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N + 1][N + 1];
        boolean[][] road = new boolean[N + 1][N + 1];
        result = 0;

        for (int i = 1; i <= N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; ++j)
                graph[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; ++i)
            Arrays.fill(road[i], true);

        Floyd_Warshall(N, graph, road);

        if (result != -1) {
            int total = 0;

            for (int i = 1; i <= N; ++i) {
                for (int j = 1; j <= N; ++j) {
                    if (road[i][j])
                        total += graph[i][j];
                }
            }

            result = total / 2;
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
