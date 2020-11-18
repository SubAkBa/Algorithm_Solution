import java.util.*;

public class Solution_RangeSumofSortedSubarraySums {

    public static int rangeSum(int[] nums, int n, int left, int right) {
        int MOD = 1000000007;
        int range = n * (n + 1) / 2, idx = 0;
        int[] sum = new int[range];

        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                if (i == j)
                    sum[idx] = nums[j];
                else
                    sum[idx] = (sum[idx - 1] + nums[j]) % MOD;
                ++idx;
            }
        }

        Arrays.sort(sum);

        int total = 0;
        for (int i = left - 1; i < right && i < range; ++i)
            total = (total + sum[i]) % MOD;

        return total;
    }

    public static void main(String[] args) {
        System.out.println(rangeSum(new int[]{1, 2, 3, 4}, 4, 1, 5)); // 13
        System.out.println(rangeSum(new int[]{1, 2, 3, 4}, 4, 3, 4)); // 6
        System.out.println(rangeSum(new int[]{1, 2, 3, 4}, 4, 1, 10)); // 50
    }
}
