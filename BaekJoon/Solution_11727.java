import java.io.*;

public class Solution_11727 {
	static int[] tile;

	public static int Tiling(int n) {
		if (n <= 0)
			return 0;

		if (tile[n] != 0)
			return tile[n];

		return tile[n] = (Tiling(n - 1) + Tiling(n - 2) * 2) % 10007;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		tile = new int[1001];

		tile[1] = 1;
		tile[2] = 3;

		Tiling(n);

		bw.write(tile[n] + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
