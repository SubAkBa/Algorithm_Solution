import java.io.*;
import java.util.*;

public class Solution_3184 {
    static int R, C;
    static int sheep, wolf;
    static int[] d = {-1, 0, 1, 0, -1};

    public static void BFS(char[][] map, int x, int y) {
        int curSheep = 0, curWolf = 0;
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{x, y});

        if (map[x][y] == 'o')
            ++curSheep;
        else if (map[x][y] == 'v')
            ++curWolf;

        map[x][y] = '#';

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; ++i) {
                int nx = cur[0] + d[i];
                int ny = cur[1] + d[i + 1];

                if (!(0 <= nx && nx < R && 0 <= ny && ny < C))
                    continue;

                if (map[nx][ny] == '#')
                    continue;

                if (map[nx][ny] == 'v')
                    ++curWolf;
                else if (map[nx][ny] == 'o')
                    ++curSheep;

                map[nx][ny] = '#';
                queue.offer(new int[]{nx, ny});
            }
        }

        if (curSheep > curWolf)
            wolf -= curWolf;
        else
            sheep -= curSheep;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        sheep = 0;
        wolf = 0;

        char[][] map = new char[R][C];

        for (int i = 0; i < R; ++i) {
            map[i] = br.readLine().toCharArray();

            for (int j = 0; j < C; ++j) {
                if (map[i][j] == 'v')
                    ++wolf;
                else if (map[i][j] == 'o')
                    ++sheep;
            }
        }

        for (int i = 1; i < R - 1; ++i) {
            for (int j = 1; j < C - 1; ++j) {
                if (map[i][j] != '#')
                    BFS(map, i, j);
            }
        }

        bw.write(sheep + " " + wolf);
        bw.flush();
        bw.close();
        br.close();
    }
}
