import java.util.*;
import java.io.*;

public class Solution_1806 {

	public static int TwoPointer(int[] nums, int N, int S) {
		int len = Integer.MAX_VALUE, start = 0, end = 0, total = 0;

		while (end <= N) {
			if (total < S) {
				total += nums[end++];
				continue;
			}

			len = Math.min(len, end - start);
			total -= nums[start++];
		}

		return (len == Integer.MAX_VALUE ? 0 : len);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] nums = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(st.nextToken());

		bw.write(TwoPointer(nums, N, S) + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
