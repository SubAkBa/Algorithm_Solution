import java.util.*;
import java.io.*;

public class Solution_8983 {

    public static boolean Binary_Search(int M, int[] shot, int x, int y, int L) {
        int left = 0, right = M - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // |X - a| + b <= L
            // a + b - L <= X <= a - b + L
            int upper = x - y + L, lower = x + y - L;
            if (lower <= shot[mid] && shot[mid] <= upper)
                return true;
            else if (lower > shot[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] shot = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; ++i)
            shot[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(shot);

        int count = 0;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (y > L)
                continue;

            if (Binary_Search(M, shot, x, y, L))
                ++count;
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
