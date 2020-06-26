import java.util.*;
import java.io.*;

public class Solution_1021 {
	static int N, M;

	public static int Rotating_Q(LinkedList<Integer> list, int[] extract) {
		int total = 0;

		for (int i = 0; i < M; i++) {
			int lidx = 0, ridx = list.size() - 1;
			int lcount = 0, rcount = 0;

			while (list.get(lidx++) != extract[i])
				lcount++;

			while (list.get(ridx--) != extract[i])
				rcount++;

			if (lcount <= rcount) {
				while ((lcount--) > 0) {
					list.addLast(list.pollFirst());
					total++;
				}
			} else {
				while ((rcount--) > -1) {
					list.addFirst(list.pollLast());
					total++;
				}
			}

			list.pollFirst();
		}

		return total;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] extract = new int[M];

		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 1; i <= N; i++)
			list.add(i);

		for (int i = 0; i < M; i++)
			extract[i] = Integer.parseInt(st.nextToken());

		bw.write(Rotating_Q(list, extract) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}