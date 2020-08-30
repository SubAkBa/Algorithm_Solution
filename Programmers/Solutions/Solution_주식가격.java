import java.util.*;

public class Solution_stockprice {

	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		Stack<Stock> sp = new Stack<>();

		for (int i = 0; i < prices.length; i++) {
			if (sp.isEmpty() || sp.peek().price <= prices[i])
				sp.push(new Stock(i, prices[i]));
			else {
				while (!sp.isEmpty() && sp.peek().price > prices[i]) {
					Stock temp = sp.pop();

					answer[temp.idx] = i - temp.idx;
				}
				
				sp.push(new Stock(i, prices[i]));
			}
		}
		
		while (!sp.isEmpty()) {
			Stock temp = sp.pop();

			answer[temp.idx] = prices.length - 1 - temp.idx;
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] { 1, 2, 3, 2, 3 })));
	}

}

class Stock {
	int idx, price;

	public Stock(int idx, int price) {
		this.idx = idx;
		this.price = price;
	}
}