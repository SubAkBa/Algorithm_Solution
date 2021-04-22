import java.util.*;
import java.io.*;

public class Solution_12837 {

    public static void Update(long[] tree, int start, int end, int idx, long diff, int node) {
        if (!(start <= idx && idx <= end))
            return;

        tree[node] += diff;

        if (start == end)
            return;

        int mid = (start + end) / 2;
        Update(tree, start, mid, idx, diff, node * 2);
        Update(tree, mid + 1, end, idx, diff, node * 2 + 1);
    }

    public static long Query(long[] tree, int start, int end, int left, int right, int node) {
        if (right < start || left > end)
            return 0;

        if (left <= start && end <= right)
            return tree[node];

        int mid = (start + end) / 2;
        return Query(tree, start, mid, left, right, node * 2) + Query(tree, mid + 1, end, left, right, node * 2 + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int h = (int) (Math.log(N) / Math.log(2));
        long[] tree = new long[1 << (h + 1) + 1];

        while ((--Q) >= 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                Update(tree, 1, N, b, c, 1);
            } else
                bw.write(Query(tree, 1, N, b, c, 1) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
