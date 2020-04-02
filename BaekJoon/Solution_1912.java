import java.util.*;
import java.io.*;

public class Solution_1912 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine()), answer = -1000;
		int[] narr = new int[n], total = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			narr[i] = Integer.parseInt(st.nextToken());

		answer = total[0] = narr[0];

		for (int i = 1; i < n; i++) {
			total[i] = Math.max(total[i - 1] + narr[i], narr[i]);
			answer = Math.max(total[i], answer);
		}

		bw.write(answer + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
