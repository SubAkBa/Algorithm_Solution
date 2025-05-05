public class Solution_ValidPerfectSquare {
	public static boolean isPerfectSquare(int num) {
		return Math.sqrt(num) * 10 % 10 == 0;
	}

	public static void main(String[] args) {
		System.out.println(isPerfectSquare(16)); // true
		System.out.println(isPerfectSquare(14)); // false
		System.out.println(isPerfectSquare(8)); // false
		System.out.println(isPerfectSquare(9)); // true
		System.out.println(isPerfectSquare(1)); // true
	}
}
