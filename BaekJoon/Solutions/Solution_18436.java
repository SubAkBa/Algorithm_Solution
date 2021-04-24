import java.util.*;
import java.io.*;

public class Solution_18436 {

    public static int oddInit(int[] nums, int[] tree, int start, int end, int node) {
        if (start == end)
            return tree[node] = (nums[start] & 1) == 1 ? 1 : 0;

        int mid = (start + end) / 2;
        return tree[node] = oddInit(nums, tree, start, mid, node * 2) + oddInit(nums, tree, mid + 1, end, node * 2 + 1);
    }

    public static void oddUpdate(int[] tree, int start, int end, int idx, int diff, int node) {
        if (!(start <= idx && idx <= end))
            return;

        tree[node] += diff;

        if (start == end)
            return;

        int mid = (start + end) / 2;
        oddUpdate(tree, start, mid, idx, diff, node * 2);
        oddUpdate(tree, mid + 1, end, idx, diff, node * 2 + 1);
    }

    public static int Query(int[] tree, int start, int end, int left, int right, int node) {
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
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N + 1];
        for (int i = 1; i <= N; ++i)
            nums[i] = Integer.parseInt(st.nextToken());

        int h = (int) (Math.log(N) / Math.log(2));
        int[] oddTree = new int[1 << (h + 1) + 1];

        oddInit(nums, oddTree, 1, N, 1);

        int M = Integer.parseInt(br.readLine());
        while ((--M) >= 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                boolean isNOdd = (nums[b] & 1) == 1;
                boolean isCOdd = (c & 1) == 1;

                if (isCOdd == isNOdd)
                    continue;

                nums[b] = c;
                oddUpdate(oddTree, 1, N, b, isCOdd ? 1 : -1, 1);
            } else {
                int value = Query(oddTree, 1, N, b, c, 1);
                bw.write((a == 3 ? value : c - b + 1 - value) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
