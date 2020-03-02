import java.util.*;
import java.io.*;

public class simulation_2979_solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] cost = { 0, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()) };
		int[][] parktime = new int[3][3];
		int total = 0, count = 0, max = 0;

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++)
				parktime[i][j] = Integer.parseInt(st.nextToken());
			max = Math.max(max, parktime[i][1]);
		}

		for (int i = 0; i < max; i++) {
			for (int j = 0; j < 3; j++) {
				if (parktime[j][0] == i)
					count++;

				if (parktime[j][1] == i)
					count--;
			}
			total += count * cost[count];
		}
		bw.write(total + " ");

		bw.flush();
		bw.close();
		br.close();
	}

}
