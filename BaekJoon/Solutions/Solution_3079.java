import java.util.*;
import java.io.*;

public class Solution_3079 {
	static int N, M;
	static long[] time;

	public static long Binary_Search(long max) {
		long left = 1, right = (long) max * M;

		while (left < right) {
			long mid = (left + right) / 2;

			long count = 0;
			for (int i = 0; i < N; i++)
				count += (long) mid / time[i];

			if (count >= M)
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

		time = new long[N];
		long max = 0;
		for (int i = 0; i < N; i++) {
			time[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, time[i]);
		}

		bw.write(Binary_Search(max) + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
