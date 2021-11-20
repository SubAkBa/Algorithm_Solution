import java.util.*;
import java.io.*;

public class Solution_2096 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][3];
        int[][] maxDp = new int[N][3];
        int[][] minDp = new int[N][3];
        for (int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; ++j)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 3; ++i) {
            maxDp[0][i] = arr[0][i];
            minDp[0][i] = arr[0][i];
        }

        for (int i = 1; i < N; ++i) {
            maxDp[i][0] = Math.max(maxDp[i - 1][0], maxDp[i - 1][1]) + arr[i][0];
            minDp[i][0] = Math.min(minDp[i - 1][0], minDp[i - 1][1]) + arr[i][0];

            maxDp[i][1] = Math.max(Math.max(maxDp[i - 1][0], maxDp[i - 1][1]), maxDp[i - 1][2]) + arr[i][1];
            minDp[i][1] = Math.min(Math.min(minDp[i - 1][0], minDp[i - 1][1]), minDp[i - 1][2]) + arr[i][1];

            maxDp[i][2] = Math.max(maxDp[i - 1][1], maxDp[i - 1][2]) + arr[i][2];
            minDp[i][2] = Math.min(minDp[i - 1][1], minDp[i - 1][2]) + arr[i][2];
        }

        bw.write(Math.max(maxDp[N - 1][0], Math.max(maxDp[N - 1][1], maxDp[N - 1][2])) + " " +
                Math.min(minDp[N - 1][0], Math.min(minDp[N - 1][1], minDp[N - 1][2])));
        bw.flush();
        bw.close();
        br.close();
    }
}
