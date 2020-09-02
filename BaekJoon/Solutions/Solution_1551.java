import java.util.*;
import java.io.*;

public class simulation_1551_solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int len = Integer.parseInt(st.nextToken());
		int count = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), ",");
		int[] seq = new int[len + 1];
		for (int i = 1; i <= len; i++)
			seq[i] = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= count; i++) {
			for (int j = 1; j <= len - i; j++) {
				seq[j] = seq[j + 1] - seq[j];
			}
			seq[len - i + 1] = 0;
		}

		for (int i = 1; i <= len - count; i++)
			sb.append(seq[i] + ",");
		
		bw.write(sb.deleteCharAt(sb.length() - 1).toString() + " ");

		bw.flush();
		bw.close();
		br.close();
	}

}
