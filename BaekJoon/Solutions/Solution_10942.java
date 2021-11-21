import java.util.*;
import java.io.*;

public class Solution_10942 {

    public static void dp(int N, int[] nums, boolean[][] isPalindrome) {
        for (int i = 1; i <= N; ++i) {
            isPalindrome[i][i] = true;

            if (nums[i - 1] == nums[i])
                isPalindrome[i - 1][i] = true;
        }

        for (int gap = 2; gap <= N; ++gap) {
            for (int start = 1; start <= N - gap; ++start) {
                if (isPalindrome[start + 1][start + gap - 1] && nums[start] == nums[start + gap])
                    isPalindrome[start][start + gap] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; ++i)
            nums[i] = Integer.parseInt(st.nextToken());

        boolean[][] isPalindrome = new boolean[N + 1][N + 1];

        dp(N, nums, isPalindrome);

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());

            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            bw.write(isPalindrome[S][E] ? "1\n" : "0\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
