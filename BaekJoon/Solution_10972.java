import java.util.*;
import java.io.*;

public class permutation_10972_solution {
	public static void NextPermutation(int[] permu) {
		int answer = 0;
		int previdx = -1, postidx = -1;

		for (int i = 0; i < permu.length - 1; i++) {
			if (permu[i] < permu[i + 1])
				previdx = i;
		}

		if (previdx == -1) {
			System.out.print(-1);
			
			return;
		}

		for (int i = previdx + 1; i < permu.length; i++) {
			if (permu[previdx] < permu[i])
				postidx = i;
		}

		Swap(permu, previdx, postidx);

		for (int i = previdx + 1; i < (previdx + 1 + (permu.length - previdx - 1) / 2); i++)
			Swap(permu, i, permu.length - i + previdx);

		for (int i = 0; i < permu.length; i++)
			System.out.print(permu[i] + " ");
	}

	public static void Swap(int[] arr, int i, int j) {
		int temp = arr[i];

		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		int[] permu = new int[num];

		String[] strpermu = br.readLine().split(" ");

		for (int i = 0; i < num; i++)
			permu[i] = Integer.parseInt(strpermu[i]);

		NextPermutation(permu);
	}

}
