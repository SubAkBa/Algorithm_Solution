public class Solution_FibonacciNumber {
    static int[] dp = new int[31];

    public static int fib(int n) {
        if (n <= 1)
            return n;

        if (dp[n] != 0)
            return dp[n];

        return dp[n] = fib(n - 2) + fib(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(fib(2)); // 1
        System.out.println(fib(3)); // 2
        System.out.println(fib(4)); // 3
    }
}
