import java.util.*;
import java.io.*;

public class eratos_6588_solution {
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

		int n;
		while ((n = Integer.parseInt(br.readLine())) != 0) {
			for (int i = 3;; i += 2) {
				if (Eratosthenes_Sieve(i) && Eratosthenes_Sieve(n - i)) {
					bw.write(n + " = " + i + " + " + (n - i) + "\n");
					break;
				}
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
