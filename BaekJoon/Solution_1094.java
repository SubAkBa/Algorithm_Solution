import java.util.*;
import java.io.*;

public class simulation_1094_solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int stick = 64, count = 0;
		int target = Integer.parseInt(st.nextToken());

		while (target > 0) {

			if (stick >= target) {
				while (stick > target)
					stick /= 2;
				target -= stick;
				count++;
			}

		}

		bw.write(count + " ");

		bw.flush();
		bw.close();
		br.close();
	}

}
