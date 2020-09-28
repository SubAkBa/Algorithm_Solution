import java.util.*;
import java.io.*;

public class Solution_1062 {
	static int max_count, ALPHABET = 26;

	public static void DFS(String[] words, int K, int key, int num) {
		if (K == 0) {
			int temp_count = 0;

			for (String word : words) {
				int wlen = word.length(), j;

				for (j = 0; j < wlen; ++j) {
					if ((key & (1 << (word.charAt(j) - 'a'))) == 0)
						break;

				}

				if (j == wlen)
					++temp_count;
			}

			max_count = Math.max(max_count, temp_count);
			return;
		}

		if (num == ALPHABET)
			return;

		if ((key & (1 << num)) == 0) {
			key ^= 1 << num;
			DFS(words, K - 1, key, num + 1);
			key ^= 1 << num;
		}

		DFS(words, K, key, num + 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		max_count = (K == ALPHABET ? N : 0);

		int key = 0;
		String[] words = new String[N];

		for (int i = 0; i < N; ++i) {
			words[i] = br.readLine();
			words[i] = words[i].substring(4, words[i].length() - 4);
		}

		for (char c : new char[] { 'a', 'n', 't', 'i', 'c' })
			key |= 1 << (c - 'a');

		if (5 <= K && K < ALPHABET)
			DFS(words, K - 5, key, 0);

		bw.write(max_count + "");
		bw.flush();
		bw.close();
		br.close();
	}
}