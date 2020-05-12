import java.io.*;

public class Solution_2156 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] grape = new int[n + 1], total = new int[n + 1];

		for (int i = 1; i <= n; i++)
			grape[i] = Integer.parseInt(br.readLine());

		total[1] = grape[1];

		if (n > 1) {
			total[2] = grape[2] + grape[1];

			for (int i = 3; i <= n; i++)
				total[i] = Math.max(Math.max(total[i - 2], grape[i - 1] + total[i - 3]) + grape[i], total[i - 1]);
		}

		bw.write(total[n] + " ");
		bw.flush();
		bw.close();
		br.close();
	}
}
