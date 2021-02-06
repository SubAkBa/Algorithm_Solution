import java.util.*;
import java.io.*;

public class Solution_1303 {
    static int[] d = new int[]{-1, 0, 1, 0, -1};
    static int N, M;

    public static int DFS(char[][] map, int x, int y, char c) {
        int count = 1;
        map[x][y] = '-';

        for (int i = 0; i < 4; ++i) {
            int nx = x + d[i];
            int ny = y + d[i + 1];

            if (!(0 <= nx && nx < M && 0 <= ny && ny < N))
                continue;

            if (map[nx][ny] == '-' || map[nx][ny] != c)
                continue;

            count += DFS(map, nx, ny, c);
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        char[][] map = new char[M][N];
        for (int i = 0; i < M; ++i) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < N; ++j)
                map[i][j] = temp[j];
        }

        int BPower = 0, WPower = 0;
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                if (map[i][j] == 'B')
                    BPower += Math.pow(DFS(map, i, j, map[i][j]), 2);
                else if (map[i][j] == 'W')
                    WPower += Math.pow(DFS(map, i, j, map[i][j]), 2);
            }
        }

        bw.write(WPower + " " + BPower);
        bw.flush();
        bw.close();
        br.close();
    }
}
