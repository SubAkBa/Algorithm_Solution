import java.util.*;

public class Solution_KConcatenationMaximumSum {
    static int MOD = 1000000007;

    public static int kConcatenationMaxSum(int[] arr, int k) {
        int len = arr.length;

        long sum = 0;
        for (int i = 0; i < len; ++i)
            sum = (sum + arr[i]) % MOD;

        long oneMax = 0, oneTemp = 0;
        for (int i = 0; i < len; ++i) {
            oneTemp = Math.max(arr[i], arr[i] + oneTemp) % MOD;
            oneMax = Math.max(oneMax, oneTemp);
        }

        long twoMax = 0, twoTemp = 0;
        if (k > 1) {
            for (int i = 0; i < len * 2; ++i) {
                twoTemp = Math.max(arr[i % len], arr[i % len] + twoTemp) % MOD;
                twoMax = Math.max(twoMax, twoTemp);
            }
        }

        return (int) Math.max(Math.max(sum * k, oneMax), Math.max(twoMax, (k - 2) * sum + twoMax) % MOD);
    }


    public static void main(String[] args) {
        System.out.println(kConcatenationMaxSum(new int[]{1, 2}, 3)); // 9
        System.out.println(kConcatenationMaxSum(new int[]{1, 2}, 1)); // 3
        System.out.println(kConcatenationMaxSum(new int[]{1, -2, 1}, 5)); // 2
        System.out.println(kConcatenationMaxSum(new int[]{-1, -2}, 7)); // 0
        System.out.println(kConcatenationMaxSum(new int[]{-5, -2, 0, 0, 3, 9, -2, -5, 4}, 5)); // 20
        System.out.println(kConcatenationMaxSum(new int[]{-9, 13, 4, -16, -12, -16, 3, -7, 5, -16, 16, 8, -1, -13, 15, 3}, 6)); // 36
    }
}
