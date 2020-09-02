import java.util.*;
import java.io.*;

public class Solution_1049 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int answer = 0;

		int[] guitar = { Integer.MAX_VALUE, Integer.MAX_VALUE };

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int pack = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken());

			guitar[0] = Math.min(guitar[0], pack);
			guitar[1] = Math.min(guitar[1], one);
		}

		if (N >= 6) {
			answer = Math.min(guitar[0], guitar[1] * 6) * (N / 6);
			N %= 6;
		}

		if (N < 6)
			answer += Math.min(guitar[0], guitar[1] * N);

		bw.write(answer + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
