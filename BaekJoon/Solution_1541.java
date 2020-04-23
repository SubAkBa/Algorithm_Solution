import java.util.*;
import java.io.*;

public class Solution_1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), "+-", true);
		int total = Integer.parseInt(st.nextToken());
		boolean minus = false;

		while (st.hasMoreTokens()) {
			char c = st.nextToken().charAt(0);

			if (c == '-') {
				total -= Integer.parseInt(st.nextToken());
				minus = true;
			} else if (c == '+' && minus) {
				total -= Integer.parseInt(st.nextToken());
			} else
				total += Integer.parseInt(st.nextToken());
		}

		bw.write(total + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
