import java.util.*;
import java.io.*;

public class Solution_2309 {
	static boolean find = false;

	public static void PickDwarf(int n, int r, int hidx, int oidx, int[] height, int[] output) {
		if (find)
			return;

		if (r == 0) {
			int total = 0;
			for (int num : output)
				total += num;

			if (total == 100) {
				find = true;
				Arrays.sort(output);

				for (int i = 0; i < 7; i++)
					System.out.println(output[i]);
			}
			return;
		}

		if (hidx == n)
			return;

		output[oidx] = height[hidx];
		PickDwarf(n, r - 1, hidx + 1, oidx + 1, height, output);
		PickDwarf(n, r, hidx + 1, oidx, height, output);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] height = new int[9];
		int[] output = new int[7];

		for (int i = 0; i < 9; i++)
			height[i] = Integer.parseInt(br.readLine());

		PickDwarf(9, 7, 0, 0, height, output);
	}

}
