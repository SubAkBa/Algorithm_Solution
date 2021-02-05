import java.util.*;
import java.io.*;

public class Solution_1926 {
    static int[] d = new int[]{-1, 0, 1, 0, -1};
    static int n, m;

    public static int DFS(int[][] map, int x, int y) {
        int count = 1;
        map[x][y] = 0;

        for (int i = 0; i < 4; ++i) {
            int nx = x + d[i];
            int ny = y + d[i + 1];

            if (!(0 <= nx && nx < n && 0 <= ny && ny < m))
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
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; ++j)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int type = 0, count = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (map[i][j] == 0)
                    continue;

                ++type;
                count = Math.max(count, DFS(map, i, j));
            }
        }

        bw.write(type + "\n" + count);
        bw.flush();
        bw.close();
        br.close();
    }
}
