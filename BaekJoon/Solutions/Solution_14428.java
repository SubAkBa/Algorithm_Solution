import java.util.*;
import java.io.*;

public class Solution_14428 {
    static int[] nums;

    public static int getMinIdx(int x, int y) {
        if (x == -1)
            return y;

        if (y == -1)
            return x;

        if (nums[x] == nums[y])
            return Math.min(x, y);

        return nums[x] < nums[y] ? x : y;
    }

    public static int Init(int[] tree, int start, int end, int node) {
        if (start == end)
            return tree[node] = start;

        int mid = (start + end) / 2;
        return tree[node] = getMinIdx(Init(tree, start, mid, node * 2), Init(tree, mid + 1, end, node * 2 + 1));
    }

    public static int Update(int[] tree, int start, int end, int idx, int n, int node) {
        if (!(start <= idx && idx <= end) || start == end)
            return tree[node];

        int mid = (start + end) / 2;
        return tree[node] = getMinIdx(Update(tree, start, mid, idx, n, node * 2), Update(tree, mid + 1, end, idx, n, node * 2 + 1));
    }

    public static int Query(int[] tree, int start, int end, int left, int right, int node) {
        if (right < start || left > end)
            return -1;

        if (left <= start && end <= right)
            return tree[node];

        int mid = (start + end) / 2;
        return getMinIdx(Query(tree, start, mid, left, right, node * 2), Query(tree, mid + 1, end, left, right, node * 2 + 1));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[N + 1];
        for (int i = 1; i <= N; ++i)
            nums[i] = Integer.parseInt(st.nextToken());

        int h = (int) (Math.log(N) / Math.log(2));
        int[] tree = new int[1 << (h + 1) + 1];

        Init(tree, 1, N, 1);

        int M = Integer.parseInt(br.readLine());
        while ((--M) >= 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                nums[b] = c;
                Update(tree, 1, N, b, c, 1);
            } else
                bw.write(Query(tree, 1, N, b, c, 1) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
