import java.util.*;

public class Solution_합승택시요금 {

    public static void Floyd_Warshall(int n, int[][] graph) {
        for (int via = 1; via <= n; ++via) {
            for (int from = 1; from <= n; ++from) {
                for (int to = 1; to <= n; ++to) {
                    if (from == to || via == to || from == via)
                        continue;

                    if (graph[from][to] > graph[from][via] + graph[via][to])
                        graph[from][to] = graph[from][via] + graph[via][to];
                }
            }
        }
    }

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] graph = new int[n + 1][n + 1];
        int INF = 87654321;

        for (int i = 1; i <= n; ++i)
            Arrays.fill(graph[i], INF);

        for (int[] f : fares)
            graph[f[0]][f[1]] = graph[f[1]][f[0]] = f[2];

        Floyd_Warshall(n, graph);

        int first = INF;
        for (int i = 1; i <= n; ++i)
            first = Math.min(first, graph[s][i] + graph[i][a] + graph[i][b]);

        return Math.min(Math.min(graph[s][a] + graph[a][b], graph[s][b] + graph[b][a]), Math.min(first, graph[s][a] + graph[s][b]));
    }

    public static void main(String[] args) {
        System.out.println(solution(6, 4, 6, 2, new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}})); // 82
        System.out.println(solution(7, 3, 4, 1, new int[][]{{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}})); // 14
        System.out.println(solution(6, 4, 5, 6, new int[][]{{2, 6, 6}, {6, 3, 7}, {4, 6, 7}, {6, 5, 11}, {2, 5, 12}, {5, 3, 20}, {2, 4, 8}, {4, 3, 9}})); // 18

    }
}
