import java.util.*;
import java.io.*;

public class Solution_treasurechestpassword {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine()), count = 0;

		while ((count++) < T) {
			HashSet<Integer> set = new HashSet<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			StringBuilder sb = new StringBuilder(br.readLine());

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

			bw.write("#" + count + " " + list.get(K - 1) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
