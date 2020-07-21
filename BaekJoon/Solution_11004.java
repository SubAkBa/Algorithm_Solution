import java.util.*;
import java.io.*;

public class Solution_11004 {

	public static void Swap(int[] nums, int n1, int n2) {
		int temp = nums[n1];
		nums[n1] = nums[n2];
		nums[n2] = temp;
	}

	public static int Select(int[] nums, int left, int right) {
		int mid = (left + right) >> 1;
		int pivot = nums[mid];

		Swap(nums, left, mid);

		while (left < right) {

			while (left < right && pivot <= nums[right])
				--right;

			nums[left] = nums[right];

			while (left < right && pivot >= nums[left])
				++left;

			nums[right] = nums[left];
		}

		nums[left] = pivot;

		return left;
	}

	public static int Quick_Selection(int[] nums, int left, int right, int K) {
		while (left <= right) {
			int idx = Select(nums, left, right);

			if (idx == K)
				return nums[idx];
			else if (idx < K)
				left = idx + 1;
			else
				right = idx - 1;
		}

		return nums[left];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()) - 1;

//		List<Integer> nums = new ArrayList<>();
		int[] nums = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(st.nextToken());
//			nums.add(Integer.parseInt(st.nextToken()));

//		Collections.sort(nums);

		bw.write(Quick_Selection(nums, 0, N - 1, K) + "");
//		bw.write(nums.get(K));
		bw.flush();
		bw.close();
		br.close();
	}

}
