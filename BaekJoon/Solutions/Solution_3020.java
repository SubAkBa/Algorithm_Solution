import java.util.*;
import java.io.*;

public class Solution_3020 {
	static int N, H;

	public static void Counting_Sort(int[] arr) {
		int[] count = new int[H], sorted = new int[N];

		for (int i = 0; i < N / 2; i++)
			count[arr[i]]++;

		for (int i = 1; i < H; i++)
			count[i] += count[i - 1];

		for (int i = 0; i < N / 2; i++)
			sorted[--count[arr[i]]] = arr[i];

		for (int i = 0; i < N / 2; i++)
			arr[i] = sorted[i];
	}

	public static int[] Break_Obstacle(int[] top, int[] bottom) {
		int[] answer = new int[] { Integer.MAX_VALUE, 0 };
		int[] wall = new int[N + 1];

		Counting_Sort(top);
		Counting_Sort(bottom);

		for (int h = 1; h <= H; h++) {
			int tcount = Upper_Bound(top, H - h);
			int bcount = Lower_Bound(bottom, h);

			if (top[tcount] <= (H - h))
				tcount++;

			if (bottom[bcount] < h)
				bcount++;

			int count = N - (tcount + bcount);
			answer[0] = Math.min(answer[0], count);
			wall[count]++;
		}

		answer[1] = wall[answer[0]];

		return answer;
	}

	public static int Upper_Bound(int[] arr, int value) {
		int left = 0, right = (N / 2) - 1;

		while (left < right) {
			int mid = (left + right) / 2;

			if (value < arr[mid])
				right = mid;
			else
				left = mid + 1;
		}

		return right;
	}

	public static int Lower_Bound(int[] arr, int value) {
		int left = 0, right = (N / 2) - 1;

		while (left < right) {
			int mid = (left + right) / 2;

			if (value <= arr[mid])
				right = mid;
			else
				left = mid + 1;
		}

		return right;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		int[] top = new int[N / 2], bottom = new int[N / 2];

		for (int i = 0; i < N; i++) {
			if (i % 2 == 0)
				bottom[i / 2] = Integer.parseInt(br.readLine());
			else
				top[i / 2] = Integer.parseInt(br.readLine());
		}

		int[] answer = Break_Obstacle(top, bottom);

		bw.write(answer[0] + " " + answer[1]);
		bw.flush();
		bw.close();
		br.close();
	}

}
