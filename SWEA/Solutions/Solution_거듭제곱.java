import java.io.*;
import java.util.*;

public class Solution_거듭제곱 {

	public static int PowFunc(int N, int M) {
		if (M == 1)
			return N;

		return N * PowFunc(N, M - 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = 10;

		while ((--T) >= 0) {
			int tnum = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			bw.write("#" + tnum + " " + PowFunc(N, M) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
