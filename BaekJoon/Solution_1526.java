import java.io.*;

public class Solution_1526 {
	static int[] type;
	static int answer = 0;
	static String N;

	public static void Permutation(StringBuilder str, int r) {
		if (str.length() == r) {
			StringBuilder sb = new StringBuilder(str.toString());
			int temp = Integer.parseInt(sb.reverse().toString());

			if (Integer.parseInt(N) >= temp)
				answer = Math.max(answer, temp);

			return;
		}

		for (int i = 0; i < 2; i++) {
			str.append(type[i]);

			Permutation(str, r);

			str.deleteCharAt(str.length() - 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = br.readLine();
		type = new int[] { 7, 4 };
		int len = N.length();

		for (int i = len; i >= 1; i--)
			Permutation(new StringBuilder(), i);

		bw.write(answer + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
