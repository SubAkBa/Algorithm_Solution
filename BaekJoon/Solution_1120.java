import java.util.*;
import java.io.*;

public class Solution_1120 {

	public static int StrCompare(String A, String B) {
		int alen = A.length(), blen = B.length();
		int min = Integer.MAX_VALUE;

		for (int i = 0; i <= blen - alen; i++) {
			int count = 0;
			for (int j = 0; j < alen; j++) {
				if (A.charAt(j) != B.charAt(i + j))
					count++;
			}

			min = Math.min(min, count);
		}

		return min;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String A = st.nextToken();
		String B = st.nextToken();

		bw.write(StrCompare(A, B) + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
