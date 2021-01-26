import java.util.*;
import java.io.*;

public class Solution_11780 {
    static int[][] graph, path;
    static int n, m, INF = 987654321;

    public static void Floyd_Warshall() {
        for (int via = 1; via <= n; ++via) {
            for (int from = 1; from <= n; ++from) {
                for (int to = 1; to <= n; ++to) {
                    if (from == to)
                        continue;

                    if (graph[from][to] > graph[from][via] + graph[via][to]) {
                        graph[from][to] = graph[from][via] + graph[via][to];
                        path[from][to] = via;
                    }
                }
            }
        }
    }

    public static void FindPath(List<Integer> pathList, int start, int end) {
        if (path[start][end] == 0) {
            pathList.add(start);
            pathList.add(end);
            return;
        }
        FindPath(pathList, start, path[start][end]);
        pathList.remove(pathList.size() - 1);
        FindPath(pathList, path[start][end], end);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new int[n + 1][n + 1];
        path = new int[n + 1][n + 1];

        for (int i = 1; i <= n; ++i)
            Arrays.fill(graph[i], INF);

        for (int i = 0; i < m; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a][b] = (graph[a][b] == 0 ? c : Math.min(graph[a][b], c));
        }

        Floyd_Warshall();

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j)
                bw.write((i == j ? 0 : graph[i][j]) + " ");
            bw.newLine();
        }

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (graph[i][j] == INF)
                    bw.write("0");
                else {
                    List<Integer> pathList = new ArrayList<>();
                    FindPath(pathList, i, j);
                    bw.write(pathList.size() + " ");

                    for (int p : pathList)
                        bw.write(p + " ");
                }

                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
