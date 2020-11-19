import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_11049 {
    static int INF = 987654321;

    public static int DFS(int N, int[][] mat, int[][] dp, int left, int right) {
        if (left == right)
            return 0;

        if (dp[left][right] != 0)
            return dp[left][right];

        dp[left][right] = INF;
        for (int mid = left; mid < right; ++mid) {
            dp[left][right] = Math.min(dp[left][right],
                    DFS(N, mat, dp, left, mid) + DFS(N, mat, dp, mid + 1, right) + mat[left][0] * mat[mid][1] * mat[right][1]);
        }

        return dp[left][right];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[][] mat = new int[N][2];
        for (int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            mat[i][0] = r;
            mat[i][1] = c;
        }

        bw.write(DFS(N, mat, new int[N][N], 0, N - 1) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
