import java.util.*;

public class Solution_ShortestPathVisitingAllNodes {

	public static class Element {
		int idx, mask;

		public Element(int idx, int mask) {
			this.idx = idx;
			this.mask = mask;
		}
	}

	public static int shortestPathLength(int[][] graph) {
		int N = graph.length, count = 0;
		Set<String> cache = new HashSet<>();
		Queue<Element> queue = new LinkedList<>();

		for (int i = 0; i < N; ++i) {
			Element e = new Element(i, 1 << i);

			cache.add(e.idx + " " + e.mask);
			queue.offer(e);
		}

		while (true) {
			int depth = queue.size();

			while ((--depth) >= 0) {
				Element from = queue.poll();

				if (from.mask == ((1 << N) - 1))
					return count;

				for (int to : graph[from.idx]) {
					int toMask = from.mask | (1 << to);

					if (cache.contains(to + " " + toMask))
						continue;

					cache.add(to + " " + toMask);
					queue.offer(new Element(to, toMask));
				}
			}

			++count;
		}
	}

	public static void main(String[] args) {
		System.out.println(shortestPathLength(new int[][] { { 1, 2, 3 }, { 0 }, { 0 }, { 0 } })); // 4
		System.out.println(shortestPathLength(new int[][] { { 1 }, { 0, 2, 4 }, { 1, 3, 4 }, { 2 }, { 1, 2 } })); // 4
	}
}
