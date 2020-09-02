import java.io.*;

public class Solution_1644 {

	public static int SetPrime(int[] prime) {
		int MAX = 4000000, idx = 0;
		int sqrt = (int) Math.sqrt(MAX);
		boolean[] ischecked = new boolean[MAX + 1];
		
		for (int i = 2; i <= sqrt; i++) {
			if (ischecked[i])
				continue;

			for (int j = i + i; j <= MAX; j += i)
				ischecked[j] = true;
		}

		for (int i = 2; i <= MAX; i++) {
			if (!ischecked[i])
				prime[idx++] = i;
		}

		return idx;
	}

	public static int TwoPointer(int[] prime, int len, int N) {
		int count = 0, start = 0, end = 0, total = 0;

		while (end < len) {
			if (total < N) {
				total += prime[end++];
				continue;
			}

			if (total == N)
				count++;

			total -= prime[start++];
		}

		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] prime = new int[283146 + 1];

		int idx = SetPrime(prime);

		bw.write(TwoPointer(prime, idx, N) + " ");
		bw.flush();
		bw.close();
		br.close();
	}
}
