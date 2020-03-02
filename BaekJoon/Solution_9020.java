import java.util.*;
import java.io.*;

public class eratos_9020_solution {

	public static boolean Eratosthenes_Sieve(int n) {
		if (n <= 1)
			return false;

		if (n == 2)
			return true;

		if (n % 2 == 0)
			return false;

		int sqrtn = (int) Math.sqrt((double) n);
		for (int i = 3; i <= sqrtn; i += 2) {
			if (n % i == 0)
				return false;
		}

		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testcase = Integer.parseInt(br.readLine());

		for (int i = 0; i < testcase; i++) {
			int n = Integer.parseInt(br.readLine());

			for (int j = n / 2;; j--) {
				if (Eratosthenes_Sieve(j) && Eratosthenes_Sieve(n - j)) {
					bw.write(j + " " + (n - j) + "\n");
					break;
				}
			}

		}

		bw.flush();
		bw.close();
		br.close();
	}

}
