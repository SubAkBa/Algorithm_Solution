import java.util.*;
import java.io.*;

public class floyd_11404_solution {
	static int[][] dist;
	static int city, bus;

	public static void Floyd_Warshall() {

		for (int via = 1; via <= city; via++) {
			for (int from = 1; from <= city; from++) {
				
				if(dist[from][via] == 0)
					continue;
				
				for (int to = 1; to <= city; to++) {

					if (from == to || dist[via][to] == 0)
						continue;

					if(dist[from][to] == 0 || dist[from][to] > dist[from][via] + dist[via][to])
						dist[from][to] = dist[from][via] + dist[via][to];
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		city = Integer.parseInt(br.readLine());
		bus = Integer.parseInt(br.readLine());

		dist = new int[city + 1][city + 1];

		for (int i = 1; i <= bus; i++) {
			String[] infos = br.readLine().split(" ");

			int from = Integer.parseInt(infos[0]);
			int to = Integer.parseInt(infos[1]);
			int cost = Integer.parseInt(infos[2]);

			if (dist[from][to] == 0 || dist[from][to] > cost)
				dist[from][to] = cost;
		}

		Floyd_Warshall();

		for (int i = 1; i <= city; i++) {
			for (int j = 1; j <= city; j++)
				System.out.print(dist[i][j] + " ");
			System.out.println();
		}
	}

}
