import java.util.*;

public class Solution_diskcontroller {

	public static int solution(int[][] jobs) {
		int jobcounts = jobs.length;
		int answer = 0;

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

		List<int[]> joblist = new ArrayList<>();

		for (int i = 0; i < jobcounts; ++i)
			joblist.add(jobs[i]);

		Collections.sort(joblist, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

		int idx = 0, time = 0;
		while (idx < jobcounts || !pq.isEmpty()) {

			while (idx < jobcounts) {
				int[] current = joblist.get(idx);

				if (current[0] > time)
					break;

				pq.offer(joblist.get(idx));
				++idx;
			}

			boolean isSingle = false;

			if (pq.size() == 0) {
				pq.offer(joblist.get(idx));
				++idx;
				isSingle = true;
			}

			int[] current = pq.poll();

			if (isSingle) {
				answer += current[1];
				time = current[0] + current[1];
			} else {
				answer += time - current[0] + current[1];
				time += current[1];
			}
		}

		return answer / jobcounts;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 0, 3 }, { 1, 9 }, { 2, 6 } }));
	}
}
