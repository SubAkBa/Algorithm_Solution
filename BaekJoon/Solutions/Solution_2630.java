import java.util.*;
import java.io.*;

public class Solution_2630 {
    static int[] count;

    public static void Divide_Conquer(int[][] map, int N, int x, int y) {
        if (N == 1) {
            ++count[map[x][y]];
            return;
        }

        boolean isDiff = false;

        for (int i = x; i < x + N && !isDiff; ++i) {
            for (int j = y; j < y + N; ++j) {
                if (map[x][y] != map[i][j]) {
                    isDiff = true;
                    break;
                }
            }
        }

        if (isDiff) {
            Divide_Conquer(map, N / 2, x, y);
            Divide_Conquer(map, N / 2, x + N / 2, y);
            Divide_Conquer(map, N / 2, x, y + N / 2);
            Divide_Conquer(map, N / 2, x + N / 2, y + N / 2);
        } else
            ++count[map[x][y]];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        count = new int[2];

        for (int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; ++j)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        Divide_Conquer(map, N, 0, 0);

        bw.write(count[0] + "\n" + count[1]);
        bw.flush();
        bw.close();
        br.close();
    }
}
