import java.util.*;

public class Solution_PerfectSquares {

	public boolean is_square(int n) {
		int sqrt_n = (int) Math.sqrt(n);
		return (sqrt_n * sqrt_n == n);
	}

	// Based on Lagrange's Four Square theorem, there
	// are only 4 possible results: 1, 2, 3, 4.
	public int numSquares(int n) {
		// If n is a perfect square, return 1.
		if (is_square(n)) {
			return 1;
		}

		// The result is 4 if and only if n can be written in the
		// form of 4^k*(8*m + 7). Please refer to
		// Legendre's three-square theorem.
		while ((n & 3) == 0) // n%4 == 0
		{
			n >>= 2;
		}
		if ((n & 7) == 7) // n%8 == 7
		{
			return 4;
		}

		// Check whether 2 is the result.
		int sqrt_n = (int) Math.sqrt(n);
		for (int i = 1; i <= sqrt_n; i++) {
			if (is_square(n - i * i)) {
				return 2;
			}
		}

		return 3;
	}

	public static int BFS(int max_n, int n) {
		Queue<int[]> queue = new LinkedList<>();

		int step = 0;
		queue.offer(new int[] { max_n, n });

		while (!queue.isEmpty()) {

			int size = queue.size();

			while ((--size) >= 0) {
				int[] current = queue.poll();

				if (current[1] < 0)
					continue;

				if (current[1] == 0)
					return step;

				int cur_num = current[0];
				while (current[1] - (cur_num * cur_num) < 0)
					--cur_num;

				for (int i = cur_num; i >= 1; --i)
					queue.offer(new int[] { i, current[1] - (i * i) });
			}

			++step;
		}

		return step;
	}

	public static int numSquares(int n) {
		int max_n = (int) Math.sqrt((double) n);

		return BFS(max_n, n);
	}

	public static int numSquares(int n) {
		int[] dp = new int[n + 1];

		dp[0] = 0;
		for (int i = 1; i <= n; ++i) {
			int min = Integer.MAX_VALUE;

			for (int j = 1; j <= i * i; ++j) {
				if (i >= j * j)
					min = Math.min(min, dp[i - j * j] + 1);
			}

			dp[i] = min;
		}

		return dp[n];
	}

	static List<Integer> list = new ArrayList<>();
	public static int numSquares(int n) {
        
        if (list.size() == 0)
		    list.add(0);

		if (list.size() <= n) {

			for (int j = list.size(); j <= n; ++j) {
				int min = Integer.MAX_VALUE;

				for (int i = 1; i * i <= j; ++i)
					min = Math.min(min, list.get(j - i * i) + 1);

				list.add(min);
			}
		}

		return list.get(n);
	}

	public static void main(String[] args) {
		System.out.println(numSquares(12)); // 3
		System.out.println(numSquares(13)); // 2
	}
}
