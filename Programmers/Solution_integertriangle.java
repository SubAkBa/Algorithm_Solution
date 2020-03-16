
public class Solution_integertriangle {
	
	public static int solution(int[][] triangle) {
		int max = 0;

		for (int i = 1; i < triangle.length; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) // 빨간색 왼쪽 부분 
					triangle[i][j] += triangle[i - 1][j];
				else if (i == j) // 빨간색 오른쪽 부분
					triangle[i][j] += triangle[i - 1][j - 1];
				else // 파란색 삼각형 부분
					triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);

				if (i == triangle.length - 1)
					max = Math.max(max, triangle[i][j]);
			}
		}

		return max;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } }));

	}

}
