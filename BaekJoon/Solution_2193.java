import java.io.*;
import java.math.*;

public class Solution_2193 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		BigInteger[] count = new BigInteger[N + 1];
		
		count[0] = new BigInteger("0");
		count[1] = new BigInteger("1");

		if (N == 1)
			bw.write(count[N] + " ");
		else {
			for (int i = 2; i <= N; i++)
				count[i] = new BigInteger("0").add(count[i - 1].add(count[i - 2]));
			bw.write(count[N] + " ");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
