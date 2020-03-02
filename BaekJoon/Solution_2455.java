import java.util.*;
import java.io.*;

public class simulation_2455_solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int max = 0;
		int result = 0;

		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());

			while (st.hasMoreTokens()) {
				result -= Integer.parseInt(st.nextToken());
				result += Integer.parseInt(st.nextToken());

				max = Math.max(max, result);
			}
		}
		
		bw.write(max + " ");
		
		bw.flush();
		bw.close();
		br.close();
	}

}
