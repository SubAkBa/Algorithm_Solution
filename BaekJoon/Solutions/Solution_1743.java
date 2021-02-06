import java.util.*;
import java.io.*;

public class Solution_1743 {
    static int[] d = new int[]{-1, 0, 1, 0, -1};
    static int N, M;

    public static int DFS(int[][] map, int x, int y) {
        int count = 1;
        map[x][y] = 0;

        for (int i = 0; i < 4; ++i) {
            int nx = x + d[i];
            int ny = y + d[i + 1];

            if (!(1 <= nx && nx <= N && 1 <= ny && ny <= M))
                continue;

            if (map[nx][ny] == 0)
                continue;

            count += DFS(map, nx, ny);
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][M + 1];
        while ((--K) >= 0) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r][c] = 1;
        }

        int answer = 0;
        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= M; ++j) {
                if (map[i][j] == 0)
                    continue;

                answer = Math.max(answer, DFS(map, i, j));
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
