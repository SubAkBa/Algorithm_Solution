import java.util.*;
import java.io.*;

public class Solution_1655 {

	public static int Lower_Bound(List<Integer> list, int target) {
		int left = 0, right = list.size() - 1;

		if (left > right)
			return 0;

		while (left < right) {
			int mid = left + (right - left) / 2;

			if (target <= list.get(mid))
				right = mid;
			else
				left = mid + 1;
		}

		return right;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		List<Integer> list = new ArrayList<>();
		list.add(-10001);
		for (int i = 0; i < N; ++i) {
			int value = Integer.parseInt(br.readLine());

			if (list.get(list.size() - 1) <= value)
				list.add(value);
			else
				list.add(Lower_Bound(list, value), value);

			bw.write(list.get(list.size() / 2) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
