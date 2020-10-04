import java.util.*;
import java.io.*;

public class Solution_12865 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] weight = new int[K + 1];
		int[][] stuff = new int[N][2];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());

			stuff[i][0] = Integer.parseInt(st.nextToken());
			stuff[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; ++i) {
			for (int j = K; j >= stuff[i][0]; --j)
				weight[j] = Math.max(weight[j], weight[j - stuff[i][0]] + stuff[i][1]);
		}

		bw.write(weight[K] + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
