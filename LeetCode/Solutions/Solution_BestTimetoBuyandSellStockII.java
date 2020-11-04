
public class Solution_BestTimetoBuyandSellStockII {

	public static int maxProfit(int[] prices) {
		int len = prices.length;

		int total = 0;
		int prev = prices[0];
		
		for (int i = 1; i < len; ++i) {
			if (prev < prices[i])
				total += prices[i] - prev;
			
			prev = prices[i];
		}

		return total;
	}

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 })); // 7
		System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 4, 6 })); // 7
		System.out.println(maxProfit(new int[] { 1, 2, 3, 4, 5 })); // 4
		System.out.println(maxProfit(new int[] { 7, 6, 4, 3, 1 })); // 0
	}
}
