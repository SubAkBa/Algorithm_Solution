import java.util.*;
import java.io.*;

public class Solution_6236 {
	static int[] money;
	static int N, M;

	public static boolean Check(int mid) {
		int count = 1, sum = mid;

		for (int i = 0; i < N; i++) {
			if (mid < money[i])
				return false;

			if (sum < money[i]) {
				sum = mid;
				count++;
			}

			sum -= money[i];
		}

		return M >= count;
	}

	public static int Binary_Search(int total) {
		int left = 1, right = total;

		while (left < right) {
			int mid = (left + right) / 2;

			if (Check(mid))
				right = mid;
			else
				left = mid + 1;
		}

		return right;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		money = new int[N];
		int total = 0;

		for (int i = 0; i < N; i++) {
			money[i] = Integer.parseInt(br.readLine());
			total += money[i];
		}

		bw.write(Binary_Search(total) + "");
		bw.flush();
		bw.close();
		br.close();

	}

}
