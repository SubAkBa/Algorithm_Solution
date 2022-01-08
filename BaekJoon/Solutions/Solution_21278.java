import java.util.*;
import java.io.*;

public class Solution_21278 {
    static int[][] dist;
    static int N, M, INF = 987654321;

    public static void floydWarshall() {
        for (int via = 1; via <= N; ++via) {
            for (int from = 1; from <= N; ++from) {
                for (int to = 1; to <= N; ++to) {
                    if (from == to)
                        continue;

                    if (dist[from][to] > dist[from][via] + dist[via][to]) {
                        dist[from][to] = dist[from][via] + dist[via][to];
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N + 1][N + 1];

        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= N; ++j)
                dist[i][j] = (i == j) ? 0 : INF;
        }

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            dist[A][B] = dist[B][A] = 1;
        }

        floydWarshall();

        int minTotalDist = Integer.MAX_VALUE;
        int[] answer = new int[2];
        for (int i = 1; i < N; ++i) {
            for (int j = 2; j <= N; ++j) {
                int tempTotalDist = 0;

                for (int k = 1; k <= N; ++k)
                    tempTotalDist += Math.min(dist[i][k], dist[j][k]);

                if (minTotalDist > tempTotalDist) {
                    minTotalDist = tempTotalDist;
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }

        bw.write(answer[0] + " " + answer[1] + " " + minTotalDist * 2);
        bw.flush();
        bw.close();
        br.close();
    }
}
