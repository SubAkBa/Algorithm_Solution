import java.io.*;

public class Solution_1003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		while ((T--) > 0) {
			int N = Integer.parseInt(br.readLine());

			if (N == 0)
				bw.write("1 0\n");
			else if (N == 1)
				bw.write("0 1\n");
			else {
				int[][] count = new int[N + 1][2];
				count[0][0] = count[1][1] = 1;
				
				for (int i = 2; i <= N; i++) {
					count[i][0] = count[i - 1][0] + count[i - 2][0];
					count[i][1] = count[i - 1][1] + count[i - 2][1];
				}

				bw.write(count[N][0] + " " + count[N][1] + "\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
