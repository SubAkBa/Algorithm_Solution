import java.util.*;
import java.io.*;

public class floyd_1389_solution {
	static int users, relate;
	static int[][] dist;

	public static void Floyd_Warshall() {
		for (int via = 1; via <= users; via++) {
			for (int from = 1; from <= users; from++) {
				
				if (dist[from][via] == 0)
					continue;
				
				for (int to = 1; to <= users; to++) {
					
					if (dist[via][to] == 0)
						continue;
					
					if(dist[from][to] == 0) {
						dist[from][to] = dist[from][via] + dist[via][to];
					} else {
						dist[from][to] = Math.min(dist[from][to], dist[from][via] + dist[via][to]);
					}
				}
			}
		}
	}

	public static void GetMinKevins() {
		int min = Integer.MAX_VALUE;
		int idx = 0;
		
		for (int i = 1; i <= users; i++) {
			int kevin = 0;

			for (int j = 1; j <= users; j++)
				kevin += dist[i][j];
			
			if(min > kevin) {
				min = kevin;
				idx = i;
			}
		}
		
		System.out.println(idx);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] infos = br.readLine().split(" ");
		users = Integer.parseInt(infos[0]);
		relate = Integer.parseInt(infos[1]);

		dist = new int[users + 1][users + 1];

		for (int i = 0; i < relate; i++) {
			String[] infos2 = br.readLine().split(" ");

			int from = Integer.parseInt(infos2[0]);
			int to = Integer.parseInt(infos2[1]);

			dist[from][to] = dist[to][from] = 1;
		}

		Floyd_Warshall();
		
		GetMinKevins();
	}

}
