import java.io.*;

public class Solution_14727 {

	public static long DivideNConquer(long[] height, int left, int right) {
		if (left == right)
			return height[left];

		int mid = (left + right) / 2;
		long max_area = Math.max(DivideNConquer(height, left, mid), DivideNConquer(height, mid + 1, right));

		int l = mid, r = mid + 1;

		long h = Math.min(height[l], height[r]);
		max_area = Math.max(max_area, h * (r - l + 1));

		while (left < l || r < right) {
			if (r < right && (left == l || height[l - 1] < height[r + 1]))
				h = Math.min(h, height[++r]);
			else
				h = Math.min(h, height[--l]);

			max_area = Math.max(max_area, h * (r - l + 1));
		}

		return max_area;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		long[] height = new long[N];
		for (int i = 0; i < N; ++i)
			height[i] = Integer.parseInt(br.readLine());

		bw.write(DivideNConquer(height, 0, N - 1) + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
