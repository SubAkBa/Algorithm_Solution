import java.util.*;
import java.io.*;

public class Solution_14494 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[][] map = new long[n + 1][m + 1];
        long MOD = 1000000007L;

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (i == 1 || j == 1) {
                    map[i][j] = 1;
                    continue;
                }

                map[i][j] = (map[i - 1][j] % MOD + map[i][j - 1] % MOD + map[i - 1][j - 1] % MOD) % MOD;
            }
        }

        bw.write(map[n][m] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
