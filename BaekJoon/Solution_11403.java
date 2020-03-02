import java.util.*;
import java.io.*;

public class dfs_11403_solution {
	static int[][] matrix;
	static int[] visited;
	static int[][] output;
	static int num;

	public static void DFS(int x) {

		for (int i = 1; i <= num; i++) {
			if (visited[i] == 0 && matrix[x][i] == 1) {
				visited[i] = 1;
				DFS(i);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		num = Integer.parseInt(br.readLine());

		visited = new int[num + 1];
		matrix = new int[num + 1][num + 1];
		output = new int[num + 1][num + 1];

		for (int i = 1; i <= num; i++) {
			String[] infos = br.readLine().split(" ");

			for (int j = 1; j <= num; j++)
				matrix[i][j] = Integer.parseInt(infos[j - 1]);
		}

		for (int i = 1; i <= num; i++) {
			Arrays.fill(visited, 0);

			DFS(i);

			for (int j = 1; j <= num; j++) {
				output[i][j] = visited[j];
			}
		}

		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= num; j++)
				System.out.print(output[i][j] + " ");
			System.out.println();
		}
	}

}
