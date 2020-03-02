import java.util.*;
import java.io.*;

public class floyd_2458_solution {
	static boolean[][] graph;
	static int std, comp;

	public static void Floyd_Warshall() {
		for (int via = 1; via <= std; via++) {

			for (int from = 1; from <= std; from++) {

				for (int to = 1; to <= std; to++) {

					if (graph[from][via] && graph[via][to])
						graph[from][to] = true;

				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] info = br.readLine().split(" ");
		std = Integer.parseInt(info[0]);
		comp = Integer.parseInt(info[1]);

		graph = new boolean[std + 1][std + 1];

		for (int i = 0; i < comp; i++) {
			String[] info1 = br.readLine().split(" ");

			int from = Integer.parseInt(info1[0]);
			int to = Integer.parseInt(info1[1]);

			graph[from][to] = true;
		}

		Floyd_Warshall();

		int total = 0;
		for (int i = 1; i <= std; i++) {
			int count = 0;
			
			for (int j = 1; j <= std; j++) {
				if(graph[i][j] || graph[j][i])
					count++;
			}
			
			if(count == std - 1)
				total++;
		}
		
		bw.write(total + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}

}