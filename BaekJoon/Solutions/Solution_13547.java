import java.util.*;
import java.io.*;

public class Solution_13547 {
	static int sqrt_n;

	public static class Query implements Comparable<Query> {
		int x, y, idx;

		public Query(int x, int y, int idx) {
			this.x = x;
			this.y = y;
			this.idx = idx;
		}

		public int compareTo(Query q) {
			int cx = x / sqrt_n;
			int cy = q.x / sqrt_n;

			if (cx == cy)
				return Integer.compare(y, q.y);

			return Integer.compare(cx, cy);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N + 1];
		sqrt_n = (int) Math.sqrt(N);

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; ++i)
			nums[i] = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(br.readLine());
		Query[] query = new Query[M];
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			query[i] = new Query(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
		}

		Arrays.sort(query);

		int[] counts = new int[1000001];
		int type = 0, x = 1, y = 0;

		int[] answer = new int[M];

		for (int i = 0; i < M; ++i) {
			
			while (query[i].x > x)
				if (--counts[nums[x++]] == 0)
					--type;
			
			while (query[i].x < x)
				if (++counts[nums[--x]] == 1)
					++type;
			
			while (y > query[i].y)
				if (--counts[nums[y--]] == 0)
					--type;
			
			while (y < query[i].y)
				if (++counts[nums[++y]] == 1)
					++type;

			answer[query[i].idx] = type;
		}

		for (int i = 0; i < M; ++i)
			bw.write(answer[i] + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
}
