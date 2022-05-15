import java.util.*;

public class Solution_WiggleSortII {

    public static void wiggleSort(int[] nums) {
        final int RANGE = 5000;
        int len = nums.length;
        int[] sortedNums = new int[len];
        int[] count = new int[RANGE + 1];

        for (int n : nums) {
            ++count[n];
        }

        for (int i = 1; i <= RANGE; ++i) {
            count[i] += count[i - 1];
        }

        for (int n : nums) {
            sortedNums[--count[n]] = n;
        }

        int j = len;
        for (int i = 1; i < len; i += 2) {
            nums[i] = sortedNums[--j];
        }

        for (int i = 0; i < len; i += 2) {
            nums[i] = sortedNums[--j];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 1, 1, 6, 4};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums)); // [1,4,1,5,1,6]

        nums = new int[]{1, 3, 2, 2, 3, 1};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums)); // [2,3,1,3,1,2]
    }
}
