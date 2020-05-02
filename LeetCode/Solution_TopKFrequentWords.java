import java.util.*;

public class Solution_TopKFrequentWords {

	public static List<String> topKFrequent(String[] words, int k) {
		HashMap<String, Integer> hm = new HashMap<>();

		for (String word : words)
			hm.put(word, hm.getOrDefault(word, 0) + 1);

		PriorityQueue<String> heap = new PriorityQueue<>(
				(w1, w2) -> (hm.get(w1) == hm.get(w2) ? w1.compareTo(w2) : hm.get(w2) - hm.get(w1)));

		heap.addAll(hm.keySet());

		ArrayList<String> answer = new ArrayList<>();

		while (!heap.isEmpty()) {
			if (k == 0)
				break;

			answer.add(heap.poll());
			k--;
		}

		return answer;

	}

	public static void main(String[] args) {
		System.out.println(topKFrequent(new String[] { "i", "love", "leetcode", "i", "love", "coding" }, 2));
		System.out.println(topKFrequent(
				new String[] { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" }, 4));
	}

}
