import java.io.*;
import java.util.*;

public class Solution_15651 {
    static int N, M;
    static StringBuilder sb;

    public static void DFS(int count, int[] arr) {
        if (count == M) {
            for (int l : arr)
                sb.append(l + " ");

            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; ++i) {
            arr[count] = i;
            DFS(count + 1, arr);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        DFS(0, new int[M]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
