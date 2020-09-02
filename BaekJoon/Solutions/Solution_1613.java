import java.util.*;
import java.io.*;

public class floyd_1613_solution {
	static int count, context;
	static boolean[][] event;

	public static void Floyd_Warshall() {
		for (int via = 1; via <= count; via++) {
			for (int from = 1; from <= count; from++) {
				for (int to = 1; to <= count; to++) {
					if(event[from][via] && event[via][to])
						event[from][to] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] info1 = br.readLine().split(" ");
		count = Integer.parseInt(info1[0]);
		context = Integer.parseInt(info1[1]);

		event = new boolean[count + 1][count + 1];

		for (int i = 0; i < context; i++) {
			String[] info2 = br.readLine().split(" ");

			int from = Integer.parseInt(info2[0]);
			int to = Integer.parseInt(info2[1]);

			event[from][to] = true;
		}

		Floyd_Warshall();

		int quest = Integer.parseInt(br.readLine());
		for (int i = 0; i < quest; i++) {
			String[] qinfo = br.readLine().split(" ");

			int from = Integer.parseInt(qinfo[0]);
			int to = Integer.parseInt(qinfo[1]);

			if (event[from][to])
				sb.append(-1 + "\n");
			else if (event[to][from])
				sb.append(1 + "\n");
			else
				sb.append(0 + "\n");
		}

		bw.write(sb.toString() + " ");

		bw.flush();
		bw.close();
		br.close();
	}

}
