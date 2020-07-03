import java.util.*;

public class Solution_PermutationSequence {

	public static String getPermutation(int n, int k) {
		int[] factorial = new int[n + 1];
		List<Integer> num = new ArrayList<>();
		StringBuilder sb = new StringBuilder();

		factorial[0] = 1;
		for (int i = 1; i <= n; i++)
			factorial[i] = factorial[i - 1] * i;

		for (int i = 1; i <= n; i++)
			num.add(i);

		k--;
		
		for (int i = 1; i <= n; i++) {
			int idx = k / factorial[n - i];

			sb.append(num.remove(idx));

			k -= idx * factorial[n - i];
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(getPermutation(3, 3));
		System.out.println(getPermutation(4, 9));
	}

}
