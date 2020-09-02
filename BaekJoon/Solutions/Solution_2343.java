import java.util.*;
import java.io.*;

public class Solution_2343 {
	static int N, M;
	static int[] lesson;

	public static boolean Check(int mid) {
		int sum = mid, count = 1;

		for (int i = 0; i < N; i++) {
			if (mid < lesson[i])
				return false;

			if (sum < lesson[i]) {
				count++;
				sum = mid;
			}

			sum -= lesson[i];
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

		st = new StringTokenizer(br.readLine());

		int total = 0;
		lesson = new int[N];

		for (int i = 0; i < N; i++) {
			lesson[i] = Integer.parseInt(st.nextToken());
			total += lesson[i];
		}

		bw.write(Binary_Search(total) + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
