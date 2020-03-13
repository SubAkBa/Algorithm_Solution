import java.util.*;
import java.io.*;

public class Solution_2751 {
	static int[] sorted;

	public static void Merge(int[] arr, int left, int mid, int right) {
		int low = left, high = mid + 1;
		int idx = left;

		while ((low <= mid) && (high <= right)) {
			if (arr[low] < arr[high])
				sorted[idx++] = arr[low++];
			else
				sorted[idx++] = arr[high++];
		}

		while (low <= mid)
			sorted[idx++] = arr[low++];

		while (high <= right)
			sorted[idx++] = arr[high++];

		for (int i = left; i <= right; i++)
			arr[i] = sorted[i];
	}

	public static void MergeSort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;

			MergeSort(arr, left, mid);
			MergeSort(arr, mid + 1, right);
			Merge(arr, left, mid, right);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int count = Integer.parseInt(br.readLine());
		int[] arr = new int[count];
		sorted = new int[count];

		for (int i = 0; i < count; i++)
			arr[i] = Integer.parseInt(br.readLine());

		MergeSort(arr, 0, arr.length - 1);

		for (int num : arr)
			bw.write(num + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

}
