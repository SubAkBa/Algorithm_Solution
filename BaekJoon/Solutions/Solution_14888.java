import java.util.*;
import java.io.*;

public class Solution_14888 {
	static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, operlen, N;

	public static void BetweenOperator(int[] nums, int idx, StringBuilder operstr, int calc, boolean[] selected) {
		if (idx == N) {
			max = Math.max(max, calc);
			min = Math.min(min, calc);
			return;
		}

		for (int i = 0; i < operlen; i++) {
			if (!selected[i]) {
				selected[i] = true;

				switch (operstr.charAt(i)) {
				case '+':
					BetweenOperator(nums, idx + 1, operstr, calc + nums[idx], selected);
					break;
				case '-':
					BetweenOperator(nums, idx + 1, operstr, calc - nums[idx], selected);
					break;
				case '*':
					BetweenOperator(nums, idx + 1, operstr, calc * nums[idx], selected);
					break;
				case '/':
					BetweenOperator(nums, idx + 1, operstr, calc / nums[idx], selected);
					break;
				}

				selected[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		char[] oper = { '+', '-', '*', '/' };
		StringBuilder operstr = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			int opercount = Integer.parseInt(st.nextToken());

			for (int j = 0; j < opercount; j++)
				operstr.append(oper[i]);
		}
		
		operlen = operstr.length();

		BetweenOperator(nums, 1, operstr, nums[0], new boolean[operlen]);

		bw.write(max + "\n");
		bw.write(min + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
