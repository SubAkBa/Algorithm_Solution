import java.io.*;
import java.util.*;

public class Solution_2776 {

    public static int Binary_Search(int[] note1, int N, int num) {
        int left = 0, right = N - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (note1[mid] == num)
                return 1;
            else if (note1[mid] > num)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while ((--T) >= 0) {
            int N = Integer.parseInt(br.readLine());
            int[] note1 = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; ++i)
                note1[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(note1);

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens())
                bw.write(Binary_Search(note1, N, Integer.parseInt(st.nextToken())) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
