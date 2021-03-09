import java.util.*;
import java.io.*;

public class Solution_2491 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; ++i)
            arr[i] = Integer.parseInt(st.nextToken());

        int len = 1, desc = 1, asc = 1;
        for (int i = 1; i < N; ++i) {
            if (arr[i - 1] > arr[i])
                desc = 1;
            else
                ++desc;

            if (arr[i - 1] < arr[i])
                asc = 1;
            else
                ++asc;

            len = Math.max(len, Math.max(desc, asc));
        }

        bw.write(len + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
