import java.io.*;

public class Solution_9507 {

	public static long Fibo(long[] ggoong, int n) {
		if (n < 2)
			return 1;

		if (ggoong[n] != 0)
			return ggoong[n];

		if (n == 2)
			return ggoong[n] = 2;

		if (n == 3)
			return ggoong[n] = 4;

		return ggoong[n] = Fibo(ggoong, n - 1) + Fibo(ggoong, n - 2) + Fibo(ggoong, n - 3) + Fibo(ggoong, n - 4);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		long[] ggoong = new long[68];

		for (int i = 0; i < t; ++i) {
			int n = Integer.parseInt(br.readLine());

			bw.write(Fibo(ggoong, n) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
