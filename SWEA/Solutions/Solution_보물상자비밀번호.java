import java.util.*;
import java.io.*;

public class Solution_treasurechestpassword {

	public static int KthHexaDecimal(StringBuilder sb, int N, int K) {
		HashSet<Integer> set = new HashSet<>();
		int rotate = N / 4;

		for (int i = 0; i < rotate; i++) {

			for (int j = 0; j < N; j += rotate)
				set.add(Integer.parseInt(sb.substring(j, j + rotate), 16));

			sb.append(sb.charAt(0));
			sb.deleteCharAt(0);
		}

		ArrayList<Integer> list = new ArrayList<>();
		list.addAll(set);
		Collections.sort(list, Collections.reverseOrder());

		return list.get(K - 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine()), count = 0;

		while ((count++) < T) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			StringBuilder sb = new StringBuilder(br.readLine());

			bw.write("#" + count + " " + KthHexaDecimal(sb, N, K) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
