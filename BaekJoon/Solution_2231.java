import java.io.*;

public class Solution_2231 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine()), i = 1;

		for (; i < N; i++) {
			int initializer = i;
			int temp = i;

			while (temp != 0) {
				initializer += temp % 10;
				temp /= 10;
			}

			if (initializer == N) {
				bw.write(i + " ");
				break;
			}
		}

		if (i == N)
			bw.write("0");

		bw.flush();
		bw.close();
		br.close();
	}

}
