import java.util.*;
import java.io.*;

public class Solution_1722 {
	static long[] factorial;
	static int N;

	public static int[] Permutation_Sequence(long k) {
		int[] seq = new int[N];
		int sidx = 0;

		List<Integer> num = new ArrayList<>();

		for (int i = 1; i <= N; i++)
			num.add(i);

		k--;

		for (int i = 1; i <= N; i++) {
			int idx = (int) (k / factorial[N - i]);

			seq[sidx++] = num.remove(idx);

			k -= idx * factorial[N - i];
		}

		return seq;
	}

	public static long Permutation_Order(int[] nums) {
		long order = 1;
		List<Integer> list = new LinkedList<>();

		for (int i = 1; i <= N; i++)
			list.add(i);

		for (int i = 1; i <= N; i++) {
			int idx = list.indexOf(nums[i]);
			list.remove(idx);
			order += idx * factorial[N - i];
		}

		return order;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());

		factorial = new long[N + 1];

		factorial[0] = 1;
		for (int i = 1; i <= N; i++)
			factorial[i] = factorial[i - 1] * i;

		StringTokenizer st = new StringTokenizer(br.readLine());

		switch (Integer.parseInt(st.nextToken())) {
		case 1:
			long k = Long.parseLong(st.nextToken());

			for (int num : Permutation_Sequence(k))
				bw.write(num + " ");
			break;
		case 2:
			int[] nums = new int[N + 1];

			for (int i = 1; i <= N; i++)
				nums[i] = Integer.parseInt(st.nextToken());

			bw.write(Permutation_Order(nums) + "");
			break;
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
