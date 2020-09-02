import java.io.*;

public class Solution_1280 {
	static int LEN = 200010;
	static long DIV = 1000000007;

	public static void Update(long[] tree, int idx, long diff) {
		while (idx <= LEN) {
			tree[idx] += diff;
			idx += (idx & -idx);
		}
	}

	public static long Query(long[] tree, int idx) {
		long calc = 0;

		while (idx > 0) {
			calc += tree[idx];
			idx -= (idx & -idx);
		}

		return calc;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		long[] point_tree = new long[LEN + 1];
		long[] count_tree = new long[LEN + 1];

		long answer = 1;

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine()) + 1;

			if (i > 0) {
				long lcount = Query(count_tree, num - 1);
				long ltotal = Query(point_tree, num - 1);
				long lresult = (long) (lcount * num) - ltotal;

				long rcount = (Query(count_tree, LEN) - Query(count_tree, num));
				long rtotal = (Query(point_tree, LEN) - Query(point_tree, num));
				long rresult = rtotal - (long) (rcount * num);

				answer *= ((lresult + rresult) % DIV);
				answer %= DIV;
			}

			Update(point_tree, num, num);
			Update(count_tree, num, 1);
		}

		bw.write(answer + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
