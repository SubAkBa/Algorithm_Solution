import java.util.*;
import java.io.*;

public class trie_9934_solution {

	public static void BinaryBuilding(int[][] treearr, String[] trees, int start, int end, int[] idx, int depth) {

		if (end - start < 0)
			return;

		int mid = (start + end) / 2;

		treearr[depth][idx[depth]++] = Integer.parseInt(trees[mid]);

		BinaryBuilding(treearr, trees, start, mid - 1, idx, depth + 1);
		BinaryBuilding(treearr, trees, mid + 1, end, idx, depth + 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int k = Integer.parseInt(br.readLine());
		int[][] treearr = new int[11][(int) Math.round(Math.pow(2, k - 1))];
		int[] idx = new int[10];

		for (int i = 0; i < 11; i++)
			Arrays.fill(treearr[i], 0);

		Arrays.fill(idx, 0);
		
		String[] trees = br.readLine().split(" ");

		BinaryBuilding(treearr, trees, 0, trees.length - 1, idx, 0);

		for (int i = 0; i < k; i++) {
			for (int j = 0; j < (int) Math.round(Math.pow(2, k - 1)); j++) {
				if (treearr[i][j] != 0)
					System.out.print(treearr[i][j] + " ");
			}
			System.out.println();
		}
	}
}