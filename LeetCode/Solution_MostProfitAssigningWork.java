import java.util.*;

public class Solution_MostProfitAssigningWork {

//	public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
//		int jlen = profit.length;
//
//		Job[] jobs = new Job[jlen];
//
//		for (int i = 0; i < jlen; ++i)
//			jobs[i] = new Job(difficulty[i], profit[i]);
//
//		Arrays.sort(jobs, (a, b) -> a.difficulty == b.difficulty ? Integer.compare(b.profit, a.profit)
//				: Integer.compare(a.difficulty, b.difficulty));
//
//		int wlen = worker.length, total = 0;
//
//		for (int i = 0; i < wlen; ++i) {
//			int idx = 0, max = 0;
//
//			while (idx < jlen) {
//				if (worker[i] >= jobs[idx].difficulty) {
//					max = Math.max(max, jobs[idx].profit);
//					++idx;
//					continue;
//				}
//
//				total += max;
//				break;
//			}
//
//			if (idx == jlen)
//				total += max;
//		}
//
//		return total;
//	}
//
//	public static class Job {
//		int difficulty, profit;
//
//		public Job(int difficulty, int profit) {
//			this.difficulty = difficulty;
//			this.profit = profit;
//		}
//	}

	public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
		int maxAbility = 0;

		for (int w : worker)
			maxAbility = Math.max(maxAbility, w);

		int[] maxprofits = new int[maxAbility + 1];

		int jobcount = profit.length;
		for (int i = 0; i < jobcount; ++i) {
			if (difficulty[i] <= maxAbility)
				maxprofits[difficulty[i]] = Math.max(maxprofits[difficulty[i]], profit[i]);
		}

		int maxprofit = 0;
		for (int i = 0; i <= maxAbility; ++i) {
			maxprofit = Math.max(maxprofit, maxprofits[i]);
			maxprofits[i] = maxprofit;
		}

		int total = 0;
		for (int w : worker)
			total += maxprofits[w];

		return total;
	}

	public static void main(String[] args) {
		System.out.println(maxProfitAssignment(new int[] { 2, 4, 6, 8, 10 }, new int[] { 10, 20, 30, 40, 50 },
				new int[] { 4, 5, 6, 7 })); // 100
	}
}
