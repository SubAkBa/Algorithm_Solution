import java.util.*;
import java.io.*;

public class eratos_4948_solution {

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

		int n = 0;
		while ((n = Integer.parseInt(br.readLine())) != 0) {
			int count = 0;
			for (int i = n + 1; i <= n * 2; i++) {
				if (Eratosthenes_Sieve(i))
					count++;
			}

			bw.write(count + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
