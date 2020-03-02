import java.util.*;
import java.io.*;

public class dfs_11724_solution {
	static int vertex, edge;
	static int[] visited;
	static int[][] matrix;

	public static void DFS(int x) {
		
		visited[x] = 1;

		for (int i = 1; i <= vertex; i++) {
			if(matrix[x][i] == 1 && visited[i] == 0)
				DFS(i);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] infos = br.readLine().split(" ");

		vertex = Integer.parseInt(infos[0]);
		edge = Integer.parseInt(infos[1]);

		matrix = new int[vertex + 1][vertex + 1];
		visited = new int[vertex + 1];

		int connect = 0;

		for (int i = 1; i <= edge; i++) {
			String[] edgeinfo = br.readLine().split(" ");
			int n1 = Integer.parseInt(edgeinfo[0]);
			int n2 = Integer.parseInt(edgeinfo[1]);

			matrix[n1][n2] = matrix[n2][n1] = 1;
		}

		for (int i = 1; i <= vertex; i++) {

			if (visited[i] == 0) {
				DFS(i);
				connect++;
			}
		}
		
		System.out.println(connect);
	}

}
