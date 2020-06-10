import java.util.*;
import java.io.*;

public class Solution_1654 {

	public static long CutCable(long[] cable, int K, int N, long maxlen) {
		long left = 1, right = maxlen, answer = 0;

		while (left <= right) {
			long mid = (left + right) / 2;

			int count = 0;
			for (int i = 0; i < K; i++)
				count += (cable[i] / mid);

			if (N <= count) {
				left = mid + 1;
				answer = Math.max(answer, mid);
			} else
				right = mid - 1;
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		long[] cable = new long[K];
		long maxlen = 0;

		for (int i = 0; i < K; i++) {
			cable[i] = Integer.parseInt(br.readLine());
			maxlen = Math.max(maxlen, cable[i]);
		}

		bw.write(CutCable(cable, K, N, maxlen) + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
