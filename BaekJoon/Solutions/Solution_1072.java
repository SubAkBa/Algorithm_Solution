import java.util.*;
import java.io.*;

public class Solution_1072 {

	public static long UpWinRate(long X, long Y) {
		long left = 1, right = X + 1;
		long Z = (Y * 100) / X;

		while (left < right) {
			long mid = (left + right) / 2;

			long tz = ((Y + mid) * 100) / (X + mid);

			if (Z < tz)
				right = mid;
			else
				left = mid + 1;
		}

		return ((right == X + 1) ? -1 : right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long X = Long.parseLong(st.nextToken());
		long Y = Long.parseLong(st.nextToken());

		bw.write(UpWinRate(X, Y) + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
