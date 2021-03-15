import java.util.*;
import java.io.*;

public class Solution_14430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 1][M + 1];

        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= M; ++j)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= M; ++j)
                map[i][j] += Math.max(map[i - 1][j], map[i][j - 1]);
        }

        bw.write(map[N][M] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
