import java.util.*;
import java.io.*;

public class Solution_17266 {

    public static int parametricSearch(int[] light, int N, int M) {
        int left = 0, right = N;

        while (left < right) {
            int mid = left + (right - left) / 2;
            boolean isPos = true;

            int last = 0;
            for (int i = 0; i < M; ++i) {
                if (mid + last >= light[i])
                    last = light[i] + mid;
                else {
                    isPos = false;
                    break;
                }
            }

            if (last < N)
                isPos = false;

            if (isPos)
                right = mid;
            else
                left = mid + 1;
        }

        return right;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] light = new int[M];
        for (int i = 0; i < M; ++i)
            light[i] = Integer.parseInt(st.nextToken());

        bw.write(parametricSearch(light, N, M) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
