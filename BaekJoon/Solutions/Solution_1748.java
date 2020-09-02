import java.io.*;

public class Solution_1748 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;

		int n = 1, div = 10;
		for (; N / div > 0; div *= 10) {
			answer += n * 9 * (div / 10);
			n++;
		}

		answer += n * (N - div / 10 + 1);

		bw.write(answer + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
