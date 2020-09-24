import java.util.*;

public class Solution_DistantBarcodes {

	public static int[] rearrangeBarcodes(int[] barcodes) {
		int len = barcodes.length;
		int[] answer = new int[len];
		int idx = 0, size = 10000;
		int max_idx = 0, max_count = 0;

		int[] counts = new int[size + 1];
		for (int i = 0; i < len; ++i) {
			if (max_count >= (++counts[barcodes[i]]))
				continue;

			max_count = counts[barcodes[i]];
			max_idx = barcodes[i];
		}

		for (int i = 0; i <= size; ++i) {
			int count_idx = (i == 0 ? max_idx : i);

			while ((--counts[count_idx]) >= 0) {
				answer[idx] = count_idx;

				idx = (idx + 2 >= len ? 1 : idx + 2);
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(rearrangeBarcodes(new int[] { 1, 1, 1, 2, 2, 2 }))); // [2,1,2,1,2,1]
		System.out.println(Arrays.toString(rearrangeBarcodes(new int[] { 1, 1, 1, 1, 2, 2, 3, 3 }))); // [1,3,1,3,2,1,2,1]
	}
}
