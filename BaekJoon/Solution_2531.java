import java.util.*;
import java.io.*;

public class Solution_2531 {

	public static int Rotation(int[] sushi, int N, int d, int k, int c) {
		int type_count = 0;
		int[] counts = new int[d + 1];

		for (int i = 0; i < k; ++i) {
			if (counts[sushi[i]] == 0)
				++type_count;

			++counts[sushi[i]];
		}

		int answer = type_count;

		if (counts[c] == 0)
			++answer;

		for (int i = k; i < N + k - 1; ++i) {
			if (--counts[sushi[i - k]] == 0)
				--type_count;

			if (counts[sushi[i % N]] == 0)
				++type_count;

			++counts[sushi[i % N]];

			if (counts[c] == 0)
				answer = Math.max(answer, type_count + 1);
			else
				answer = Math.max(answer, type_count);
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] sushi = new int[N];

		for (int i = 0; i < N; ++i)
			sushi[i] = Integer.parseInt(br.readLine());

		bw.write(Rotation(sushi, N, d, k, c) + " ");
		bw.flush();
		bw.close();
		br.close();
	}
}
