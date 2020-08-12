import java.util.*;
import java.io.*;

public class Solution_최빈수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		while ((--T) >= 0) {
			final int size = 101;
			int tnum = Integer.parseInt(br.readLine());
			int[] counts = new int[size];

			StringTokenizer st = new StringTokenizer(br.readLine());

			while (st.hasMoreTokens())
				++counts[Integer.parseInt(st.nextToken())];

			int idx = size - 1, max = counts[idx];
			for (int i = size - 2; i >= 0; --i) {
				if (max < counts[i]) {
					idx = i;
					max = counts[i];
				}
			}

			bw.write("#" + tnum + " " + idx + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
