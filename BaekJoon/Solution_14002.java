import java.util.*;
import java.io.*;

public class Solution_14002 {

	public static int Lower_Bound(ArrayList<Integer> list, int num) {
		int left = 0, right = list.size() - 1;

		while (left < right) {
			int mid = (left + right) / 2;

			if (num <= list.get(mid))
				right = mid;
			else
				left = mid + 1;
		}

		return right;
	}

	public static class Seq {
		int pidx, value;

		public Seq(int pidx, int value) {
			this.pidx = pidx;
			this.value = value;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];

		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Seq> sequence = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(st.nextToken());

		int idx = 0;

		list.add(nums[idx]);
		sequence.add(new Seq(idx, nums[idx]));

		for (int i = 1; i < N; i++) {
			if (list.get(idx) < nums[i]) {
				list.add(nums[i]);

				sequence.add(new Seq((++idx), nums[i]));
			} else {
				int pos = Lower_Bound(list, nums[i]);

				list.set(pos, nums[i]);

				sequence.add(new Seq(pos, nums[i]));
			}
		}

		for (int i = N - 1; i >= 0; i--) {
			Seq tseq = sequence.get(i);
			if (tseq.pidx == idx) {
				stack.push(tseq.value);
				idx--;
			}
		}

		bw.write(stack.size() + "\n");
		while (!stack.isEmpty())
			bw.write(stack.pop() + " ");

		bw.flush();
		bw.close();
		br.close();
	}

}