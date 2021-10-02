import java.io.*;
import java.util.*;

public class Solution_2792 {

    public static int binarySearch(int[] K, int N, int M, int maxValue) {
        int left = 1, right = maxValue;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;

            for (int i = 0; i < M; ++i)
                count += (K[i] - 1) / mid + 1;

            if (count <= N)
                right = mid;
            else
                left = mid + 1;
        }

        return right;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] K = new int[M];
        int maxValue = 0;
        for (int i = 0; i < M; ++i) {
            K[i] = Integer.parseInt(br.readLine());
            maxValue = Math.max(maxValue, K[i]);
        }

        bw.write(binarySearch(K, N, M, maxValue) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}