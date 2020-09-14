import java.util.*;

public class Solution_DifferentWaystoAddParentheses {

//	public static void Permutation(List<Integer> answer, List<Integer> nums, List<Character> oper) {
//		int size = nums.size();
//
//		if (size == 1) {
//			answer.add(nums.get(0));
//			return;
//		}
//
//		for (int i = size - 2; i >= 0; --i) {
//			int left = nums.get(i);
//			int right = nums.get(i + 1);
//			char o = oper.get(i);
//
//			nums.add(i, Calc(nums.remove(i), nums.remove(i), oper.remove(i)));
//			Permutation(answer, nums, oper);
//
//			nums.remove(i);
//			nums.add(i, right);
//			nums.add(i, left);
//			oper.add(i, o);
//		}
//	}
//
//	public static List<Integer> diffWaysToCompute(String input) {
//		List<Integer> answer = new ArrayList<>();
//		int len = input.length();
//		StringTokenizer st = new StringTokenizer(input, "*+-", true);
//		List<Integer> nums = new ArrayList<>();
//		List<Character> oper = new ArrayList<>();
//
//		for (int i = 0; i < len; ++i) {
//			if (i % 2 == 0)
//				nums.add(Integer.parseInt(st.nextToken()));
//			else
//				oper.add(st.nextToken().charAt(0));
//		}
//
//		Permutation(answer, nums, oper);
//
//		return answer;
//	}

	public static List<Integer> diffWaysToCompute(String input) {
		List<Integer> answer = new ArrayList<>();
		int len = input.length();

		for (int i = 0; i < len; ++i) {
			if ('0' <= input.charAt(i) && input.charAt(i) <= '9')
				continue;

			List<Integer> left = diffWaysToCompute(input.substring(0, i));
			List<Integer> right = diffWaysToCompute(input.substring(i + 1));

			for (int l : left) {
				for (int r : right)
					answer.add(Calc(l, r, input.charAt(i)));
			}
		}

		if (answer.size() == 0)
			answer.add(Integer.parseInt(input));

		return answer;
	}

	public static int Calc(int left, int right, char oper) {
		int value = 0;

		switch (oper) {
		case '*':
			value = left * right;
			break;
		case '-':
			value = left - right;
			break;
		case '+':
			value = left + right;
			break;
		}

		return value;
	}

	public static void main(String[] args) {
		System.out.println(diffWaysToCompute("2-1-1")); // [0, 2]
		System.out.println(diffWaysToCompute("2*3-4*5")); // [-34, -14, -10, -10, 10]
	}
}
