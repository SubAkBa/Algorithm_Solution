import java.util.*;
import java.io.*;

public class Solution_7578 {

    public static void Update(long[] tree, int start, int end, int idx, int node, int diff) {
        if (!(start <= idx && idx <= end))
            return;

        tree[node] += diff;

        if (start == end)
            return;

        int mid = (start + end) / 2;
        Update(tree, start, mid, idx, node * 2, diff);
        Update(tree, mid + 1, end, idx, node * 2 + 1, diff);
    }

    public static long Query(long[] tree, int start, int end, int left, int right, int node) {
        if (left > end || right < start)
            return 0;

        if (left <= start && end <= right)
            return tree[node];

        int mid = (start + end) / 2;

        return Query(tree, start, mid, left, right, node * 2) + Query(tree, mid + 1, end, left, right, node * 2 + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int R = 1000000;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[R + 1];
        for (int i = 1; i <= N; ++i)
            A[Integer.parseInt(st.nextToken())] = i;

        st = new StringTokenizer(br.readLine());
        int[] B = new int[N + 1];
        for (int i = 1; i <= N; ++i)
            B[i] = A[Integer.parseInt(st.nextToken())];

        int h = (int) (Math.log(N) / Math.log(2));
        long[] tree = new long[1 << (h + 1) + 1];

        long result = 0;
        for (int i = 1; i <= N; ++i) {
            result += Query(tree, 1, N, B[i] + 1, N, 1);
            Update(tree, 1, N, B[i], 1, 1);
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
