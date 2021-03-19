import java.util.*;
import java.io.*;

public class Solution_14722 {
    static int[] dx = {0, 1}, dy = {1, 0};

    public static int DFS(int N, int[][] map, int[][][] dp, int prev, int x, int y) {
        int next = (prev + 1) % 3;

        if (dp[x][y][next] != -1)
            return dp[x][y][next];

        dp[x][y][next] = 0;
        for (int i = 0; i < 2; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!(nx <= N && ny <= N))
                continue;

            dp[x][y][next] = Math.max(dp[x][y][next], DFS(N, map, dp, prev, nx, ny));

            if (next != map[nx][ny])
                continue;

            dp[x][y][next] = Math.max(dp[x][y][next], DFS(N, map, dp, map[nx][ny], nx, ny) + 1);
        }

        return dp[x][y][next];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N + 1][N + 1];
        int[][][] dp = new int[N + 1][N + 1][3];

        for (int i = 1; i <= N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j], -1);
            }
        }

        if (map[1][1] == 0)
            bw.write((DFS(N, map, dp, 0, 1, 1) + 1) + "");
        else
            bw.write(DFS(N, map, dp, -1, 1, 1) + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
