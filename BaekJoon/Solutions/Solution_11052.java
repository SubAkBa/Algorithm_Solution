import java.io.*;
import java.util.*;

public class Solution_11052 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] pay = new int[N + 1], total = new int[N + 1];

		for (int i = 1; i <= N; i++)
			pay[i] = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++)
				total[i] = Math.max(total[i], total[i - j] + pay[j]);
		}

		bw.write(total[N] + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
