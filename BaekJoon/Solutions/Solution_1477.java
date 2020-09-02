import java.util.*;
import java.io.*;

public class Solution_1477 {
	static int N, M, L;
	static int[] rest;

	public static int Install() {
		int left = 0, right = L;

		while (left < right) {
			int mid = (left + right) / 2;

			int count = 0;

			for (int i = 0; i < N + 1; i++) {
				int diff = rest[i + 1] - rest[i];
				int quote = diff / mid;

				if (quote > 0) {
					if (diff % mid == 0)
						count += quote - 1;
					else
						count += quote;
				}
			}

			if (count <= M)
				right = mid;
			else
				left = mid + 1;
		}

		return right;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		rest = new int[N + 2];
		rest[0] = 0;
		for (int i = 0; i < N; i++)
			rest[i] = Integer.parseInt(st.nextToken());
		rest[N + 1] = L;

		Arrays.sort(rest);

		bw.write(Install() + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
