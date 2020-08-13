import java.util.*;

public class Solution_SetMatrixZeroes {
	public static void setZeroes(int[][] matrix) {
		int row = matrix.length, col = matrix[0].length;
		HashSet<Integer> rowset = new HashSet<>();
		HashSet<Integer> colset = new HashSet<>();

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 0) {
					rowset.add(i);
					colset.add(j);
				}
			}
		}

		for (int cols : colset) {
			for (int i = 0; i < row; i++)
				matrix[i][cols] = 0;
		}

		for (int rows : rowset) {
			for (int i = 0; i < col; i++)
				matrix[rows][i] = 0;
		}

		System.out.println(Arrays.deepToString(matrix));
	}

	public static void main(String[] args) {
		setZeroes(new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } });
		setZeroes(new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } });
	}

}
