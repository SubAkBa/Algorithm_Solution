import java.util.*;
import java.io.*;

public class eratos_1929_solution {

	public static boolean Eratosthenes_sieve(int n) {
		if (n <= 1)
			return false;

		if (n == 2)
			return true;

		if (n % 2 == 0)
			return false;

		int sqrtn = (int) Math.sqrt((double) n);
		for (int i = 3; i <= sqrtn; i += 2) {
			if(n % i == 0)
				return false;
		}
		
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int min = Integer.parseInt(st.nextToken());
		int max = Integer.parseInt(st.nextToken());

		for (int i = min; i <= max; i++) {
			if (Eratosthenes_sieve(i))
				bw.write(i + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
