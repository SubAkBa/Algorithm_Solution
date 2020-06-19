import java.util.*;
import java.io.*;

public class Solution_11758 {

	public static int CounterClockWise(int[][] point) {
		int n1 = point[0][0] * point[1][1] + point[1][0] * point[2][1] + point[2][0] * point[0][1];
		int n2 = point[0][1] * point[1][0] + point[1][1] * point[2][0] + point[2][1] * point[0][0];

		if (n1 < n2)
			return -1;
		else if (n1 > n2)
			return 1;

		return 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[][] point = new int[3][2];

		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			point[i][0] = Integer.parseInt(st.nextToken());
			point[i][1] = Integer.parseInt(st.nextToken());
		}

		bw.write(CounterClockWise(point) + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
