
public class Solution_integertriangle {
	static int[][] sum, tri;
	static int len;

	public static int Subsum(int x, int y) {

		if (x == 0 && y == 0)
			return sum[0][0] = tri[0][0];

		if (sum[x][y] != 0)
			return sum[x][y];

		if (y == 0)
			return sum[x][y] = tri[x][0] + Subsum(x - 1, 0);

		if (x == y)
			return sum[x][y] = tri[x][y] + Subsum(x - 1, y - 1);

		return sum[x][y] = tri[x][y] + Math.max(Subsum(x - 1, y - 1), Subsum(x - 1, y));
	}

	public static int solution(int[][] triangle) {
		len = triangle.length;
		tri = triangle;
		sum = new int[len][len];

		int max = 0;
		
		for (int i = 0; i < len; i++)
			max = Math.max(max, Subsum(len - 1, i));

		return max;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } }));

	}

}
