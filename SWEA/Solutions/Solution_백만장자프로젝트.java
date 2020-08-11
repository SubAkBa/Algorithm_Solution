import java.util.*;
import java.io.*;

public class Solution_millionaireproject {

	public static long Millionaire_Project(int N, int[] stuff) {
		long gain = 0, cost = 0;
		int count = 0;
		int max = stuff[N - 1];

		for (int i = N - 1; i >= 0; i--) {
			if (max < stuff[i]) {
				gain += (long) count * max - cost;
				max = stuff[i];
				count = 0;
				cost = 0;
			} else {
				count++;
				cost += stuff[i];
			}

			if (i == 0 && count > 0)
				gain += (long) count * max - cost;
		}

		return gain;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine()), TC = 0;

		while ((TC++) < T) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] stuff = new int[N];

			for (int i = 0; i < N; i++)
				stuff[i] = Integer.parseInt(st.nextToken());

			bw.write("#" + TC + " " + Millionaire_Project(N, stuff) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
