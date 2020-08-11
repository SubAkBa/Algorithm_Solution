import java.io.*;
import java.util.*;

public class Solution_swimmingpool {
	static int answer;

	public static void MinCostSwimmingPool(int[] util, int[] date, int month, int cost) {
		if (month >= 12) {
			answer = Math.min(answer, cost);
			return;
		}

		if (date[month] == 0) {
			MinCostSwimmingPool(util, date, month + 1, cost);
			return;
		}

//		if (cost > util[3])
//			return;

		MinCostSwimmingPool(util, date, month + 1, cost + util[0] * date[month]);
		MinCostSwimmingPool(util, date, month + 1, cost + util[1]);
		MinCostSwimmingPool(util, date, month + 3, cost + util[2]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine()), count = 0;

		while ((count++) < T) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] util = new int[4], date = new int[12];

			for (int i = 0; i < 4; i++)
				util[i] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 12; i++)
				date[i] = Integer.parseInt(st.nextToken());
			
			answer = util[3];

			MinCostSwimmingPool(util, date, 0, 0);

			bw.write("#" + count + " " + answer + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
