import java.util.*;
import java.io.*;

public class Solution_11780 {
    static int INF = 987654321;

    public static void floydWarshall(int N, int[][] dist, int[][] next) {
        for (int k = 1; k <= N; ++k) {
            for (int i = 1; i <= N; ++i) {
                if (dist[i][k] == INF) {
                    continue;
                }

                for (int j = 1; j <= N; ++j) {
                    if (i == j || dist[k][j] == INF) {
                        continue;
                    }

                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] dist = new int[n + 1][n + 1];
        int[][] next = new int[n + 1][n + 1];

        for (int i = 1; i <= n; ++i) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (dist[a][b] > c) {
                dist[a][b] = c;
                next[a][b] = b;
            }
        }

        floydWarshall(n, dist, next);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                sb.append(dist[i][j] == INF ? 0 : dist[i][j]).append(" ");
            }
            sb.append("\n");
        }

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (i == j || next[i][j] == 0) {
                    sb.append("0\n");
                } else {
                    List<Integer> path = new ArrayList<>();
                    for (int k = i; k != j; k = next[k][j]) {
                        path.add(k);
                    }
                    path.add(j);

                    sb.append(path.size());
                    for (int p : path) {
                        sb.append(" ").append(p);
                    }
                    sb.append("\n");
                }
            }
        }

        System.out.println(sb.toString());
    }
}
