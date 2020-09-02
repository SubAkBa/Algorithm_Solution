import java.util.*;
import java.io.*;

public class Solution_1946 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		while ((T--) > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] person = new int[N + 1];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				person[a] = b;
			}

			int count = 1;
			int min = person[1];
			for (int i = 2; i <= N; i++) {
				if (min > person[i]) {
					min = person[i];
					count++;
				}
			}

			bw.write(count + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
