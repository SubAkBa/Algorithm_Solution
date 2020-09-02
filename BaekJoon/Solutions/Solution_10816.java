import java.util.*;
import java.io.*;

public class Solution_10816 {
	static int[] nums, cards;
	static int N, M;

	public static int Upper_Bound(int num) {
		int left = 0, right = N - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (nums[mid] <= num)
				left = mid + 1;
			else
				right = mid - 1;
		}

		return left;
	}

	public static int Lower_Bound(int num) {
		int left = 0, right = N - 1;

		while (left <= right) {

			int mid = (left + right) / 2;

			if (nums[mid] < num)
				left = mid + 1;
			else
				right = mid - 1;
		}

		return left;
	}

	public static int[] Binary_Search() {
		int[] counts = new int[M];

		for (int i = 0; i < M; i++)
			counts[i] = Upper_Bound(cards[i]) - Lower_Bound(cards[i]);

		return counts;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		nums = new int[N];
		for (int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(nums);

		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		cards = new int[M];
		for (int i = 0; i < M; i++)
			cards[i] = Integer.parseInt(st.nextToken());

		for (int count : Binary_Search())
			bw.write(count + " ");

		bw.flush();
		bw.close();
		br.close();
	}

}
