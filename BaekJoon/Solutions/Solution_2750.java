import java.util.*;
import java.io.*;

public class Solution_2750 {

	public static void SelectionSort(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			int minidx = i;

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minidx] > arr[j])
					minidx = j;
			}

			Swap(arr, minidx, i);
		}
	}

	public static void Swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void InsertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int compidx = i - 1;
			int temp = arr[i];
			
			while((compidx >= 0) && (arr[compidx] > temp)) {
				arr[compidx + 1] = arr[compidx];
				compidx--;
			}
			
			arr[compidx + 1] = temp;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int count = Integer.parseInt(br.readLine());
		int[] arr = new int[count];

		for (int i = 0; i < count; i++)
			arr[i] = Integer.parseInt(br.readLine());

//		SelectionSort(arr);
		InsertionSort(arr);

		for (int i = 0; i < count; i++)
			bw.write(arr[i] + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

}
