import java.util.*;
import java.io.*;

public class permutation_10974_solution {

	public static void Permutation(int[] arr, int[] out, boolean[] visit, int depth) {

		if (depth == arr.length) {
			for (int output : out)
				System.out.print(output + " ");
			System.out.println();

			return;
		}

		for (int i = 0; i < arr.length; i++) {

			if (!visit[i]) {
				visit[i] = true;
				out[depth] = arr[i];
				Permutation(arr, out, visit, depth + 1);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		int[] arr = new int[num];
		int[] out = new int[num];
		boolean[] visit = new boolean[num];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
			visit[i] = false;
		}

		Permutation(arr, out, visit, 0);
	}

}
