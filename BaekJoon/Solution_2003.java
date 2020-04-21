import java.util.*;
import java.io.*;

public class Solution_2003 {

	public static int TwoPointer(int[] nums, int N, int M) {
		int count = 0, start = 0, end = 0, total = 0;

		while (end <= N) {
			if (total < M) {
				total += nums[end++];
				continue;
			}

			if (total == M)
				count++;

			total -= nums[start++];
		}

		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] nums = new int[N + 1];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(st.nextToken());

		bw.write(TwoPointer(nums, N, M) + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
