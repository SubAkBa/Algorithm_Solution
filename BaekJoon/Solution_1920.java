import java.util.*;
import java.io.*;

public class Solution_1920 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(A);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] B = new int[M];
		for (int i = 0; i < M; i++)
			B[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < M; i++) {
			int left = 0;
			int right = N - 1;
			boolean isExist = false;

			while (left <= right) {
				int mid = (left + right) / 2;

				if (B[i] == A[mid]) {
					isExist = true;
					break;
				} else if (B[i] > A[mid])
					left = mid + 1;
				else
					right = mid - 1;
			}

			if (isExist)
				bw.write("1\n");
			else
				bw.write("0\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
