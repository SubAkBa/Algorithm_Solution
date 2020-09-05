import java.util.*;
import java.io.*;

public class Solution_1038 {

	public static void Get_Decreasing(Queue<Long> queue, int N, long[] desc_nums, int idx) {
		while (idx < N) {
			long current = queue.poll();

			long rem = current % 10;
			current *= 10;

			for (int i = 0; i < rem && idx < N; ++i) {
				long temp = current + i;
				desc_nums[++idx] = temp;
				queue.offer(temp);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		if (N < 10)
			bw.write(N + "");
		else if (N > 1022)
			bw.write("-1");
		else {
			long[] desc_nums = new long[N + 1];
			Queue<Long> queue = new LinkedList<>();

			for (int i = 1; i < 10; ++i) {
				desc_nums[i] = i;
				queue.offer((long) i);
			}

			Get_Decreasing(queue, N, desc_nums, 9);

			bw.write(desc_nums[N] + "");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
