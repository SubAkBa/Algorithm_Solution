import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2042 {
    static long[] nums;
    static long[] tree;

    public static long build(int start, int end, int node) {
        if (start == end) {
            return tree[node] = nums[start];
        }

        int mid = (start + end) >>> 1;
        int L = node << 1;
        int R = L | 1;

        return tree[node] = build(start, mid, L) + build(mid + 1, end, R);
    }

    public static long query(int start, int end, int node, int left, int right) {
        if (right < start || end < left) {
            return 0;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) >>> 1;
        int L = node << 1;
        int R = L | 1;

        return query(start, mid, L, left, right) + query(mid + 1, end, R, left, right);
    }

    public static void update(int start, int end, int node, int idx, long diff) {
        if (idx < start || end < idx) {
            return;
        }

        tree[node] += diff;

        if (start == end) {
            return;
        }

        int mid = (start + end) >>> 1;
        int L = node << 1;
        int R = L | 1;

        if (idx <= mid) {
            update(start, mid, L, idx, diff);
        } else {
            update(mid + 1, end, R, idx, diff);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        nums = new long[N + 1];

        for (int i = 1; i <= N; ++i) {
            nums[i] = Long.parseLong(br.readLine());
        }

        tree = new long[N * 4];
        build(1, N, 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; ++i) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                long diff = c - nums[b];
                nums[b] = c;
                update(1, N, 1, b, diff);
            } else if (a == 2) {
                sb.append(query(1, N, 1, b, (int)c)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
