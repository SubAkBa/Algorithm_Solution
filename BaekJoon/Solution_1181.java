import java.util.*;
import java.io.*;

public class Solution_1181 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		ArrayList<String> words = new ArrayList<>();
		HashSet<String> set = new HashSet<>();

		for (int i = 0; i < N; i++) {
			String word = br.readLine();

			if (!set.contains(word)) {
				set.add(word);
				words.add(word);
			}
		}

		Collections.sort(words,
				(s1, s2) -> (s1.length() == s2.length() ? s1.compareTo(s2) : s1.length() - s2.length()));

		for (String word : words)
			bw.write(word + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

}
