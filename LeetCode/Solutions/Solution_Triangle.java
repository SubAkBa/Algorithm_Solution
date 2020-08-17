import java.util.*;

public class Solution_Triangle {

	public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		int[] sum = new int[n];

		for (int i = 0; i < n; ++i)
			sum[i] = triangle.get(n - 1).get(i);

		for (int i = n - 2; i >= 0; --i) {
			for (int j = 0; j <= i; ++j)
				sum[j] = Math.min(sum[j], sum[j + 1]) + triangle.get(i).get(j);
		}

		return sum[0];
	}
}
