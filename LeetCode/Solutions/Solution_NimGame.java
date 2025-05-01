public class Solution_NimGame {
	public static boolean canWinNim(int n) {
		return n % 4 != 0;
	}

	public static void main(String[] args) {
		System.out.println(canWinNim(4)); // false
		System.out.println(canWinNim(1)); // true
		System.out.println(canWinNim(2)); // true
	}
}
