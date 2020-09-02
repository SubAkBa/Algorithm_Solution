import java.util.*;
import java.io.*;

public class Solution_1062 {
	static int answer, K, N, ALPHABET = 26;
	static String[] words;

	public static void Teaching(boolean[] selected, int start, int K) {
		if (K == 0) {
			int count = 0;

			for (String word : words) {
				int i = 0;

				for (; i < word.length(); i++) {
					if (!selected[word.charAt(i) - 'a'])
						break;
				}

				if (i == word.length())
					count++;
			}

			answer = Math.max(answer, count);
			return;
		}

		for (int i = start; i < ALPHABET; i++) {
			if (selected[i])
				continue;

			selected[i] = true;
			Teaching(selected, i, K - 1);
			selected[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		answer = 0;
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		if (K >= 5 && K < ALPHABET) {
			words = new String[N];

			for (int i = 0; i < N; i++) {
				words[i] = br.readLine();
				words[i] = words[i].substring(4, words[i].length() - 4);
			}

			boolean[] selected = new boolean[ALPHABET];

			selected['a' - 'a'] = true;
			selected['n' - 'a'] = true;
			selected['t' - 'a'] = true;
			selected['i' - 'a'] = true;
			selected['c' - 'a'] = true;

			Teaching(selected, 0, K - 5);
		}

		bw.write((K == ALPHABET ? N : answer) + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
