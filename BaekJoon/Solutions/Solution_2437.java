import java.util.*;
import java.io.*;

public class Solution_2437 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] scale = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++)
			scale[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(scale);

		int sum = 0;
		for (int i = 0; i < N; i++) {
			if (sum + 1 < scale[i])
				break;

			sum += scale[i];
		}

		bw.write((sum + 1) + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
