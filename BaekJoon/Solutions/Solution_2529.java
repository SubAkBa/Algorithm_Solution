import java.util.*;
import java.io.*;

public class Solution_2529 {
	static long max, min;
	static String maxstr, minstr;
	static char[] ch;

	public static void Permutation(List<Integer> permu, int idx, int k, int visited) {
		if (idx == k) {
			StringBuilder sb = new StringBuilder();

			for (int p : permu)
				sb.append(p);

			long temp = Long.parseLong(sb.toString());

			if (max < temp) {
				max = temp;
				maxstr = sb.toString();
			}

			if (min > temp) {
				min = temp;
				minstr = sb.toString();
			}

			return;
		}

		for (int i = 0; i < 10; ++i) {
			if ((visited & (1 << (i + 1))) != 0)
				continue;

			if (idx > 0) {
				int t = permu.get(idx - 1);

				if ((ch[idx - 1] == '<' && t > i) || (ch[idx - 1] == '>' && t < i))
					continue;
			}

			visited ^= (1 << (i + 1));
			permu.add(i);

			Permutation(permu, idx + 1, k, visited);

			visited ^= (1 << (i + 1));
			permu.remove(permu.size() - 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int k = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		ch = new char[k];

		for (int i = 0; i < k; ++i)
			ch[i] = st.nextToken().charAt(0);

		maxstr = "";
		minstr = "";
		max = 0;
		min = Long.MAX_VALUE;

		Permutation(new ArrayList<>(), 0, k + 1, 0);

		bw.write(maxstr + "\n" + minstr);
		bw.flush();
		bw.close();
		br.close();
	}
}
