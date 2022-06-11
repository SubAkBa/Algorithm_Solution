
public class Solution_MaximumSubarray {

        public static int maxSubArray(int[] nums) {
	    int sum = 0, result = Integer.MIN_VALUE;

    	    for (int n : nums) {
	        sum = Math.max(sum + n, n);
	        result = Math.max(result, sum);
  	    }

	    return result;
        }

	public static void main(String[] args) {
            System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); // 6
            System.out.println(maxSubArray(new int[]{1})); // 1
            System.out.println(maxSubArray(new int[]{5, 4, -1, 7, 8})); // 23
	}

}
