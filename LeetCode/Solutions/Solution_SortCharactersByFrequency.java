import java.util.*;

public class Solution_SortCharactersByFrequency {

	public static String frequencySort(String s) {
		int len = s.length(), size = 128;
		int[] counts = new int[size];
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));

		for (int i = 0; i < len; ++i)
			++counts[s.charAt(i)];

		for (int i = 0; i < size; ++i) {
			if (counts[i] == 0)
				continue;

			pq.offer(new int[] { i, counts[i] });
		}

		StringBuilder sb = new StringBuilder();

		while (!pq.isEmpty()) {
			int[] current = pq.poll();

			while ((--current[1]) >= 0)
				sb.append((char) current[0]);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(frequencySort("tree")); // eert, eetr
		System.out.println(frequencySort("cccaaa")); // cccaaa, aaaccc
		System.out.println(frequencySort("Aabb")); // bbAa, bbaA
	}
}
