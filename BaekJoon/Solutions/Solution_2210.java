import java.util.*;
import java.io.*;

public class Solution_2210 {
    static int N = 5;
    static Set<Integer> cache;
    static int[] d = new int[]{-1, 0, 1, 0, -1};

    public static void DFS(int[][] map, int count, int x, int y, int num) {
        if (count == 0) {
            cache.add(num);
            return;
        }

        for (int i = 0; i < 4; ++i) {
            int nx = x + d[i];
            int ny = y + d[i + 1];

            if (!(0 <= nx && nx < N && 0 <= ny && ny < N))
                continue;

            DFS(map, count - 1, nx, ny, num * 10 + map[nx][ny]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] map = new int[N][N];
        for (int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cache = new HashSet<>();

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j)
                DFS(map, N, i, j, map[i][j]);
        }

        bw.write(cache.size() + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
