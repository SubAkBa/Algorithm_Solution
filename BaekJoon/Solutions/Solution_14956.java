import java.util.*;
import java.io.*;

public class Solution_14956 {

	public static int[] DivideNConquer(int n, int m) {
		int[] point = null;

		if (n == 2) {
			switch (m) {
			case 0:
				point = new int[] { 1, 1 };
				break;
			case 1:
				point = new int[] { 1, 2 };
				break;
			case 2:
				point = new int[] { 2, 2 };
				break;
			case 3:
				point = new int[] { 2, 1 };
				break;
			}

			return point;
		}

		int half_n = n / 2;
		int quadrant = m / (half_n * half_n);
		point = DivideNConquer(half_n, m % (half_n * half_n));

		switch (quadrant) {
		case 0:
			point = new int[] { point[1], point[0] };
			break;
		case 1:
			point[1] += half_n;
			break;
		case 2:
			point[0] += half_n;
			point[1] += half_n;
			break;
		case 3:
			point = new int[] { 2 * half_n - point[1] + 1, half_n - point[0] + 1 };
			break;
		}

		return point;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] answer = DivideNConquer(n, m - 1);

		bw.write(answer[0] + " " + answer[1]);
		bw.flush();
		bw.close();
		br.close();
	}
}
