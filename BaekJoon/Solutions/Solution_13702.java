import java.util.*;
import java.io.*;

public class Solution_13702 {

    public static long parametricSearch(int[] ml, int N, int K) {
        int left = 0, right = Integer.MAX_VALUE;

        while (left < right) {
            int mid = left + (right - left) / 2;

            int k = 0;
            for (int i = 0; i < N; ++i)
                k += ml[i] / mid;

            if (k < K)
                right = mid;
            else
                left = mid + 1;
        }

        return right - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] ml = new int[N];
        for (int i = 0; i < N; ++i)
            ml[i] = Integer.parseInt(br.readLine());

        bw.write(parametricSearch(ml, N, K) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
