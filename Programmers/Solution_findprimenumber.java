import java.util.*;

public class Solution_findprimenumber {
	static HashSet<Integer> set;

	public static boolean isPrime(int n) {
		if (n <= 1)
			return false;

		if (n == 2)
			return true;

		if (n % 2 == 0)
			return false;

		int sqrt = (int) Math.sqrt(n);

		for (int i = 3; i <= sqrt; i += 2) {
			if (n % i == 0)
				return false;
		}

		return true;
	}

	public static void Permutation(int n, int r, String numbers, LinkedList<Integer> list, boolean[] visited) {
		if (list.size() == r) {
			String str = "";

			for (int num : list)
				str += num;

			set.add(Integer.parseInt(str));
			return;
		}

		for (int i = 0; i < numbers.length(); i++) {
			if (visited[i])
				continue;

			visited[i] = true;
			list.add(numbers.charAt(i) - '0');
			Permutation(n, r, numbers, list, visited);

			visited[i] = false;
			list.removeLast();
		}

	}

	public static int solution(String numbers) {
		int count = 0;
		set = new HashSet<>();

		boolean[] visited = new boolean[numbers.length()];
		LinkedList<Integer> list = new LinkedList<>();

		for (int i = 1; i <= numbers.length(); i++)
			Permutation(numbers.length(), i, numbers, list, visited);

		for (int num : set) {
			System.out.println("num : " + num);
			if (isPrime(num))
				count++;
		}

		return count;
	}

	public static void main(String[] args) {
		System.out.println(solution("17"));
		System.out.println(solution("011"));
	}

}
