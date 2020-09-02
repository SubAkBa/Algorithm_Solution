import java.util.*;
import java.io.*;

public class simulation_1547_solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int incup = 1;
		int[] cups = { 0, 1, 2, 3 };
		int rotate = Integer.parseInt(br.readLine());

		for (int i = 0; i < rotate; i++) {
			st = new StringTokenizer(br.readLine());

			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());

			cups[0] = cups[n1];
			cups[n1] = cups[n2];
			cups[n2] = cups[0];
		}

		for (int i = 1; i < 4; i++) {
			if (cups[i] == 1)
				bw.write(i + " ");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
