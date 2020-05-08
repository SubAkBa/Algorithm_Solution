import java.util.*;
import java.io.*;

public class Solution_12015 {

	public static int Lower_Bound(ArrayList<Integer> list, int num, int size) {
		int left = 0, right = size - 1;

		while (left < right) {
			int mid = (left + right) / 2;

			if (num <= list.get(mid))
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

		ArrayList<Integer> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());

		list.add(0);
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			int size = list.size();

			if (list.get(size - 1) < num)
				list.add(num);
			else
				list.set(Lower_Bound(list, num, size), num);
		}

		bw.write((list.size() - 1) + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
