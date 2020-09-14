import java.util.*;

public class Solution_ExpressionAddOperators {

	public static void DFS(List<String> answer, char[] result, char[] nums, int nidx, int reidx, int len, long curCalc,
			long prev, int target) {
		if (nidx == len) {
			if (curCalc == target)
				answer.add(String.valueOf(result, 0, reidx + 1));

			return;
		}

		long calc = 0;
		int opidx = ++reidx;
		for (int i = nidx; i < len; ++i) {
			calc = calc * 10 + nums[i] - '0';
			result[++reidx] = nums[i];

			result[opidx] = '+';
			DFS(answer, result, nums, i + 1, reidx, len, curCalc + calc, calc, target);

			result[opidx] = '-';
			DFS(answer, result, nums, i + 1, reidx, len, curCalc - calc, -calc, target);

			result[opidx] = '*';
			DFS(answer, result, nums, i + 1, reidx, len, curCalc - prev + prev * calc, prev * calc, target);

			if (calc == 0)
				return;
		}
	}

	public static List<String> addOperators(String num, int target) {
		List<String> answer = new ArrayList<>();
		int len = num.length();
		char[] nums = num.toCharArray();
		char[] result = new char[len * 2];

		int reidx = -1;
		long value = 0;
		for (int i = 0; i < len; ++i) {
			value = value * 10 + nums[i] - '0';
			result[++reidx] = nums[i];

			DFS(answer, result, nums, i + 1, reidx, len, value, value, target);

			if (value == 0)
				break;
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(addOperators("123", 6)); // ["1+2+3", "1*2*3"]
		System.out.println(addOperators("232", 8)); // ["2*3+2", "2+3*2"]
		System.out.println(addOperators("105", 5)); // ["1*0+5","10-5"]
		System.out.println(addOperators("00", 0)); // ["0+0", "0-0", "0*0"]
		System.out.println(addOperators("3456237490", 9191)); // []
		System.out.println(addOperators("000", 0)); // ["0*0*0","0*0+0","0*0-0","0+0*0","0+0+0","0+0-0","0-0*0","0-0+0","0-0-0"]
	}
}
