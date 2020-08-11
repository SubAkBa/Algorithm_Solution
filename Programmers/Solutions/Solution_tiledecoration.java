public class Solution_tiledecoration {

	public static long solution(int N) {
		long[] tile = new long[N + 2];

		tile[1] = 1;

		for (int i = 2; i <= N + 1; i++)
			tile[i] = tile[i - 1] + tile[i - 2];

		return (tile[N + 1] + tile[N]) * 2;
	}

	public static void main(String[] args) {
		System.out.println(solution(5));
		System.out.println(solution(6));
	}

}
