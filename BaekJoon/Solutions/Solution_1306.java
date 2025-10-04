import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1306 {

	public static void slidingWindow(int N, int M, int[] ads) {
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		int[] counts = new int[10000001];

		for (int i = 0; i < 2 * (M - 1); ++i) {
			if ((counts[ads[i]]++) == 0) {
				pq.offer(ads[i]);
			}
		}

		for (int left = 0, right = 2 * (M - 1); right < N; ++right, ++left) {
			if ((counts[ads[right]]++) == 0) {
				pq.offer(ads[right]);
			}

			while (!pq.isEmpty() && counts[pq.peek()] == 0) {
				pq.poll();
			}

			int maxLight = pq.peek();
			sb.append(maxLight).append(" ");

			--counts[ads[left]];
		}

		System.out.println(sb);
	}

	public static int build(int start, int end, int node, int[] ads, int[] tree) {
		if (start == end) {
			return tree[node] = ads[start];
		}

		int mid = (start + end) >>> 1;
		int L = node << 1;
		int R = L | 1;

		return tree[node] = Math.max(build(start, mid, L, ads, tree), build(mid + 1, end, R, ads, tree));
	}

	public static int query(int start, int end, int node, int left, int right, int[] tree) {
		if (right < start || end < left) {
			return Integer.MIN_VALUE;
		}

		if (left <= start && end <= right) {
			return tree[node];
		}

		int mid = (start + end) >>> 1;
		int L = node << 1;
		int R = L | 1;

		return Math.max(query(start, mid, L, left, right, tree), query(mid + 1, end, R, left, right, tree));
	}

	public static void segmentTree(int N, int M, int[] ads) {
		int[] tree = new int[Integer.highestOneBit(N) << 2];

		build(1, N, 1, ads, tree);

		StringBuilder sb = new StringBuilder();
		for (int i = M; i <= N - M + 1; ++i) {
			sb.append(query(1, N, 1, i - M + 1, i + M - 1, tree)).append(" ");
		}

		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] ads = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			ads[i] = Integer.parseInt(st.nextToken());
		}

		slidingWindow(N, M, ads);
		segmentTree(N, M, ads);
	}
}
