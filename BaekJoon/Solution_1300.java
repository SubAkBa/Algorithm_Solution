import java.io.*;

public class Solution_1300 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		int left = 1, right = k, answer = 0;

		while (left <= right) {
			long count = 0;
			int mid = (left + right) / 2;

			for (int i = 1; i <= N; i++)
				count += Math.min(mid / i, N);

			if (count < k)
				left = mid + 1;
			else {
				right = mid - 1;
				answer = mid;
			}
		}

		bw.write(String.valueOf(answer) + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
