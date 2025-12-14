/*
@boj.idx: 1275
@boj.tier: platinum
@boj.title: 커피숍 2
@boj.level: V
@boj.tags: Data Structure, Segment Tree
@boj.complexity: O(MlogN)/O(N)
@boj.note:
*/

import java.util.*;
import java.io.*;

public class Solution_1275 {

	public static long Sum(long[] tree, int idx) {
		long answer = 0;

		while (idx > 0) {
			answer += tree[idx];
			idx -= (idx & -idx);
		}

		return answer;
	}

	public static void Update(long[] tree, int idx, long diff) {
		while (idx < tree.length) {
			tree[idx] += diff;
			idx += (idx & -idx);
		}
	}

	public static void Swap(long n1, long n2) {
		long temp = n1;
		n1 = n2;
		n2 = temp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		long[] nums = new long[N + 1];
		long[] tree = new long[N + 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			nums[i] = Long.parseLong(st.nextToken());
			Update(tree, i, nums[i]);
		}

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			long b = Long.parseLong(st.nextToken());

			if (x > y)
				Swap(x, y);

			bw.write((Sum(tree, y) - Sum(tree, x - 1)) + "\n");

			long diff = b - nums[a];
			Update(tree, a, diff);
			nums[a] = b;
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
