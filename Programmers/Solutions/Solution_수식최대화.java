import java.util.*;

public class Solution_수식최대화 {

	public static long Calc(long n1, long n2, char o) {
		long calc = 0;

		switch (o) {
		case '*':
			calc = n1 * n2;
			break;
		case '+':
			calc = n1 + n2;
			break;
		case '-':
			calc = n1 - n2;
			break;
		}

		return calc;
	}

	public static long Calculation(int len, long[] nums, char[] oper, char[] cand_opers) {
		List<Long> numlist = new ArrayList<>();
		List<Character> operlist = new ArrayList<>();

		for (int i = 0; i < len; ++i) {
			numlist.add(nums[i]);
			operlist.add(oper[i]);
		}

		numlist.add(nums[len]);

		for (char o : cand_opers) {
			for (int i = 0; i < operlist.size(); ++i) {
				if (operlist.get(i) != o)
					continue;

				numlist.add(i, Calc(numlist.remove(i), numlist.remove(i), operlist.remove(i)));
				--i;
			}
		}

		return Math.abs(numlist.get(0));
	}

	public static long solution(String expression) {
		long answer = 0;
		StringTokenizer st = new StringTokenizer(expression, "*-+", true);
		int len = st.countTokens();
		long[] nums = new long[len / 2 + 1];
		char[] oper = new char[len / 2];

		for (int i = 0; i < len; ++i) {
			if (i % 2 == 0)
				nums[i / 2] = Long.parseLong(st.nextToken());
			else
				oper[i / 2] = st.nextToken().charAt(0);
		}

		char[][] operlist = new char[][] { { '*', '+', '-' }, { '*', '-', '+' }, { '+', '*', '-' }, { '+', '-', '*' },
				{ '-', '*', '+' }, { '-', '+', '*' } };

		for (char[] cand_opers : operlist)
			answer = Math.max(answer, Calculation(len / 2, nums, oper, cand_opers));

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution("100-200*300-500+20")); // 60420
		System.out.println(solution("50*6-3*2")); // 300
	}
}
