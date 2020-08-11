import java.util.*;
import java.io.*;

public class Solution_makenumber {
	static int max, min, N;
	static Set<String> operset;
	static StringBuilder oper;
	static int[] nums;

	public static void Calc(StringBuilder selectoper, boolean[] selected, int curcalc, int idx) {
		if (idx == N) {
			max = Math.max(max, curcalc);
			min = Math.min(min, curcalc);
			return;
		}

		if (operset.contains(selectoper.toString()))
			return;

		operset.add(selectoper.toString());

		for (int i = 0; i < N - 1; i++) {
			if (!selected[i]) {
				selected[i] = true;
				selectoper.append(oper.charAt(i));

				switch (oper.charAt(i)) {
				case '+':
					Calc(selectoper, selected, curcalc + nums[idx], idx + 1);
					break;
				case '-':
					Calc(selectoper, selected, curcalc - nums[idx], idx + 1);
					break;
				case '*':
					Calc(selectoper, selected, curcalc * nums[idx], idx + 1);
					break;
				case '/':
					Calc(selectoper, selected, curcalc / nums[idx], idx + 1);
					break;
				}

				selected[i] = false;
				selectoper.deleteCharAt(selectoper.length() - 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine()), c = 0;

		while ((c++) < T) {
			N = Integer.parseInt(br.readLine());
			nums = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());

			oper = new StringBuilder();

			for (int i = 0; i < 4; i++) {
				int count = Integer.parseInt(st.nextToken());

				for (int j = 0; j < count; j++) {
					switch (i) {
					case 0:
						oper.append("+");
						break;
					case 1:
						oper.append("-");
						break;
					case 2:
						oper.append("*");
						break;
					case 3:
						oper.append("/");
						break;
					}
				}
			}

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++)
				nums[i] = Integer.parseInt(st.nextToken());

			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			operset = new HashSet<>();

			Calc(new StringBuilder(), new boolean[N - 1], nums[0], 1);

			bw.write("#" + c + " " + (max - min) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
