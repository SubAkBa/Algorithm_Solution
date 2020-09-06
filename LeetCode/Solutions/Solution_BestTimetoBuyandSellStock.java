
public class Solution_BestTimetoBuyandSellStock {

	public static int maxProfit(int[] prices) {
		int len = prices.length;

		if (len == 0)
			return 0;

		int max_profit = 0, min_price = prices[0];

		for (int i = 1; i < len; ++i) {
			if (min_price > prices[i])
				min_price = prices[i];
			else
				max_profit = Math.max(max_profit, prices[i] - min_price);
		}

		return max_profit;
	}

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 })); // 5
		System.out.println(maxProfit(new int[] { 7, 6, 4, 3, 1 })); // 0
		System.out.println(maxProfit(new int[] {})); // 0
	}
}
