import java.util.*;
import java.io.*;

public class Solution_2565 {

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
		int N = Integer.parseInt(br.readLine()), MAX = 501;
		int[] line = new int[MAX];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			line[A - 1] = B;
		}

		ArrayList<Integer> list = new ArrayList<>();

		list.add(0);
		for (int i = 0; i < MAX; i++) {
			if (line[i] == 0)
				continue;

			if (list.get(list.size() - 1) < line[i])
				list.add(line[i]);
			else
				list.set(Lower_Bounds(list, line[i]), line[i]);
		}

		bw.write((N - list.size() + 1) + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
