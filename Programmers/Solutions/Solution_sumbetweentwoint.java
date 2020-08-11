
public class Solution_sumbetweentwoint {

	public static long solution(int a, int b) {

		if (a == b)
			return a;

		if (a > b) {
			int temp = a;
			a = b;
			b = temp;
		}

		return (long) (b - a + 1) * (b + a) / 2;
	}

	public static void main(String[] args) {
		System.out.println(solution(3, 5));
		System.out.println(solution(3, 3));
		System.out.println(solution(5, 3));
	}

}
