
public class Solution_XOROperationinanArray {

	public static int xorOperation(int n, int start) {
		int result = start;

		for (int i = 1; i < n; ++i)
			result ^= start + (i << 1);
		
		return result;
	}

	public static void main(String[] args) {
		System.out.println(xorOperation(5, 0));
		System.out.println(xorOperation(4, 3));
		System.out.println(xorOperation(1, 7));
		System.out.println(xorOperation(10, 5));
	}
}
