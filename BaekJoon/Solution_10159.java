import java.util.*;
import java.io.*;

public class floyd_10159_solution {
	static int[][] compstf;
	static int stuff, estimate;

	public static void Floyd_Warshall() {
		for (int via = 1; via <= stuff; via++) {
			for (int from = 1; from <= stuff; from++) {
				for (int to = 1; to <= stuff; to++) {
					if(compstf[from][via] == 1 && compstf[via][to] == 1)
						compstf[from][to] = 1;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		stuff = Integer.parseInt(br.readLine());
		estimate = Integer.parseInt(br.readLine());

		compstf = new int[stuff + 1][stuff + 1];

		for (int i = 0; i < estimate; i++) {
			String[] infos = br.readLine().split(" ");

			int from = Integer.parseInt(infos[0]);
			int to = Integer.parseInt(infos[1]);

			compstf[from][to] = 1;
		}

		Floyd_Warshall();

		for (int i = 1; i <= stuff; i++) {
			int count = 0;
			
			for (int j = 1; j <= stuff; j++) {
				if(i == j)
					continue;
				
				if (compstf[i][j] == 0 && compstf[j][i] == 0)
					count++;
			}
			
			bw.write(count + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
