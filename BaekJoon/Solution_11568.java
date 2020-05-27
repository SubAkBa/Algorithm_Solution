import java.util.*;
import java.io.*;

public class Solution_11568 {

	public static int Lower_Bounds(ArrayList<Integer> list, int num) {
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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();

		list.add(0);
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (list.get(list.size() - 1) < num)
				list.add(num);
			else
				list.set(Lower_Bounds(list, num), num);
		}

		bw.write((list.size() - 1) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
