public class Solution_conquerland {

	public static int solution(int[][] land) {
		int col = land.length;

		for (int i = 1; i < col; i++) {
			land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3]));
			land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]));
			land[i][2] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][3]));
			land[i][3] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2]));
		}

		return Math.max(Math.max(land[col - 1][0], land[col - 1][1]), Math.max(land[col - 1][2], land[col - 1][3]));
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } }));

	}

}
