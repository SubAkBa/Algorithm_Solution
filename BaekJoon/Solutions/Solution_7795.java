import java.io.*;
import java.util.*;

public class Solution_7795 {

    public static int lowerBound(int[] B, int a, int M) {
        int left = 0, right = M - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (a <= B[mid])
                right = mid;
            else
                left = mid + 1;
        }

        return right;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while ((--T) >= 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; ++i)
                A[i] = Integer.parseInt(st.nextToken());

            int[] B = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; ++i)
                B[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(B);

            int total = 0;
            for (int i = 0; i < N; ++i) {
                if (B[0] >= A[i])
                    total += 0;
                else if (B[M - 1] < A[i])
                    total += M;
                else
                    total += lowerBound(B, A[i], M);
            }

            bw.write(total + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
