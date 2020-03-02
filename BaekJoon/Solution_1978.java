import java.util.*;
import java.io.*;

public class eratos_1978_solution {

	public static boolean Eratosthenes_sieve(int num) {
		if (num <= 1)
			return false;

		if (num == 2)
			return true;

		if (num % 2 == 0)
			return false;

		int sqrtnum = (int) Math.sqrt((double) num);
		for (int i = 3; i <= sqrtnum; i += 2) {
			if (num % i == 0)
				return false;
		}

		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int count = Integer.parseInt(br.readLine());
		int answer = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[count];

		for (int i = 0; i < count; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

			if (Eratosthenes_sieve(arr[i]))
				answer++;
		}

		bw.write(answer + " ");

		bw.flush();
		bw.close();
		br.close();
	}

}
