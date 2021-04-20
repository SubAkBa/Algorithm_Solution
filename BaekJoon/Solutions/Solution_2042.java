import java.util.*;
import java.io.*;

public class Solution_2042 {

    public static long Init(long[] nums, long[] tree, int left, int right, int node) {
        if (left == right)
            return tree[node] = nums[left];

        int mid = (left + right) / 2;
        return tree[node] = Init(nums, tree, left, mid, node * 2) + Init(nums, tree, mid + 1, right, node * 2 + 1);
    }

    public static void Update(long[] tree, int left, int right, int idx, long diff, int node) {
        if (!(left <= idx && idx <= right))
            return;

        tree[node] += diff;

        if (left == right)
            return;

        int mid = (left + right) / 2;
        Update(tree, left, mid, idx, diff, node * 2);
        Update(tree, mid + 1, right, idx, diff, node * 2 + 1);
    }

    public static long Query(long[] tree, int left, int right, int start, int end, int node) {
        if (start > right || end < left)
            return 0;

        if (start <= left && right <= end)
            return tree[node];

        int mid = (left + right) / 2;

        return Query(tree, left, mid, start, end, node * 2) + Query(tree, mid + 1, right, start, end, node * 2 + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int h = (int) (Math.log(N) / Math.log(2));
        long[] nums = new long[N + 1];
        long[] tree = new long[1 << (h + 1) + 1];
        for (int i = 1; i <= N; ++i)
            nums[i] = Integer.parseInt(br.readLine());

        Init(nums, tree, 1, N, 1);

        for (int i = 0; i < M + K; ++i) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 1) {
                long c = Long.parseLong(st.nextToken());
                long diff = c - nums[b];
                nums[b] = c;
                Update(tree, 1, N, b, diff, 1);
            } else {
                int c = Integer.parseInt(st.nextToken());
                bw.write(Query(tree, 1, N, b, c, 1) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
