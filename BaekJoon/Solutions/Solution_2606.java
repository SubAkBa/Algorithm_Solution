import java.util.*;
import java.io.*;

public class floyd_2606_solution {
	static boolean[][] possible;
	static int com;

	public static void Floyd_Warshall() {
		for (int via = 1; via <= com; via++) {
			for (int from = 1; from <= com; from++) {
				for (int to = 1; to <= com; to++) {
					if (possible[from][via] && possible[via][to])
						possible[from][to] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		com = Integer.parseInt(br.readLine());
		int connect = Integer.parseInt(br.readLine());

		possible = new boolean[com + 1][com + 1];

		for (int i = 0; i < connect; i++) {
			String[] info = br.readLine().split(" ");

			int from = Integer.parseInt(info[0]);
			int to = Integer.parseInt(info[1]);

			possible[from][to] = possible[to][from] = true;
			
		}

		Floyd_Warshall();

		int count = 0;
		for (int i = 2; i <= com; i++) {
			if (possible[1][i])
				count++;
		}

		bw.write(count + " ");

		bw.flush();
		bw.close();
		br.close();
	}

}
