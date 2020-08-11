import java.util.*;
import java.io.*;

public class Solution_handmadeburgerexpert {

	public static int BurgerType(int N, int M, int[] ban) {
		int count = 0;

		for (int i = 1; i < N; i++) {
			int j = 0;
			
			for (; j < M; j++) {
				if ((ban[j] & i) == ban[j])
					break;
			}

			if (j == M)
				count++;
		}

		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine()), casenum = 0;

		while ((casenum++) < T) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] ban = new int[M];

			int start = (int) Math.pow(2, N);

			if (M == 0) {
				bw.write("#" + casenum + " " + start + "\n");
				continue;
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				ban[i] = (1 << (a - 1)) + (1 << (b - 1));

			}

			bw.write("#" + casenum + " " + (BurgerType(start, M, ban) + 1) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
