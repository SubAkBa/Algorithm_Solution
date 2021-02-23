import java.util.*;
import java.io.*;

public class Solution_10971 {
    static int INF = 987654321;

    public static int TSP(int N, int[][] W, int[][] cost, int current, int visited) {
        if (visited == ((1 << N) - 1))
            return W[current][0] == 0 ? INF : W[current][0];

        int min_cost = INF;
        for (int i = 0; i < N; ++i) {
            if ((visited & (1 << i)) != 0 || W[current][i] == 0)
                continue;

            min_cost = Math.min(min_cost, TSP(N, W, cost, i, (visited | (1 << i))) + W[current][i]);
        }

        return cost[current][visited] = min_cost;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] W = new int[N][N];

        for (int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j)
                W[i][j] = Integer.parseInt(st.nextToken());
        }

        bw.write(TSP(N, W, new int[N][1 << N], 0, 1) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
