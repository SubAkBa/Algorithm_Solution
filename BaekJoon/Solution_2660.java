import java.util.*;
import java.io.*;

public class floyd_2660_solution {
	static int[][] graph;
	static int person;
	static int INF = 987654321;

	public static void Floyd_Warshall() {
		for (int via = 1; via <= person; via++) {
			for (int from = 1; from <= person; from++) {
				
				if (from == via)
					continue;
				
				for (int to = 1; to <= person; to++) {
					if (from == to || via == to)
						continue;

					graph[from][to] = Math.min(graph[from][to], graph[from][via] + graph[via][to]);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		person = Integer.parseInt(br.readLine());
		graph = new int[person + 1][person + 1];

		for (int i = 1; i <= person; i++) {
			for (int j = 1; j <= person; j++) {
				if(i == j)
					graph[i][j] = 0;
				else
					graph[i][j] = INF;
			}
		}

		while (true) {
			String[] info = br.readLine().split(" ");

			int from = Integer.parseInt(info[0]);
			int to = Integer.parseInt(info[1]);

			if (from == -1 && to == -1)
				break;

			graph[from][to] = graph[to][from] = 1;
		}

		Floyd_Warshall();
		
		int[] max = new int[person + 1];
		int min = INF, total = 0;

		for (int i = 1; i <= person; i++) {
			for (int j = 1; j <= person; j++)
				max[i] = Math.max(max[i], graph[i][j]);
				
			min = Math.min(min, max[i]);
		}
		
		for(int i=1;i<=person;i++) {
			if(max[i] == min) {
				sb.append(i + " ");
				total++;
			}
		}
		
		sb.insert(0, min + " " + total + "\n");
		
		bw.write(sb.toString());

		bw.flush();
		bw.close();
		br.close();
	}

}
