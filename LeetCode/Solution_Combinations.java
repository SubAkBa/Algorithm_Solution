import java.util.*;

public class Solution_Combinations {

//	public static void Combination(List<List<Integer>> answer, List<Integer> list, int n, int k, int num) {
//		if (k == 0) {
//			answer.add(new ArrayList<>(list));
//			return;
//		}
//
//		if (num > n)
//			return;
//
//		list.add(num);
//		Combination(answer, list, n, k - 1, num + 1);
//		list.remove(list.size() - 1);
//		Combination(answer, list, n, k, num + 1);
//	}

	public static void Combination(List<List<Integer>> answer, List<Integer> list, int n, int k, int num) {
		if (k == 0) {
			answer.add(new ArrayList<>(list));
			return;
		}

		for (int i = num; i <= n - k + 1; ++i) {
			list.add(i);
			Combination(answer, list, n, k - 1, i + 1);
			list.remove(list.size() - 1);
		}
	}

	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> answer = new ArrayList<>();

		Combination(answer, new ArrayList<>(), n, k, 1);

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(combine(4, 2));
	}

}
