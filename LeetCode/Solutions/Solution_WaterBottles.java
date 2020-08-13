
public class Solution_WaterBottles {
	public static int numWaterBottles(int numBottles, int numExchange) {
		int count = 0, div = 0, temp = 0;

		while (numBottles > 0) {
			count += numBottles;

			temp = numBottles + div;
			numBottles = temp / numExchange;
			div = temp % numExchange;
		}

		return count;
	}

	public static void main(String[] args) {
		System.out.println(numWaterBottles(9, 3));
		System.out.println(numWaterBottles(15, 4));
		System.out.println(numWaterBottles(5, 5));
		System.out.println(numWaterBottles(2, 3));
	}
}
