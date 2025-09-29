import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_11728 {

	public static void twoPointer(int N, int M, int[] A, int[] B) {
		int aIdx = 0, bIdx = 0;

		StringBuilder sb = new StringBuilder();
		while (aIdx < N && bIdx < M) {
			if (A[aIdx] > B[bIdx]) {
				sb.append(B[bIdx]).append(" ");
				++bIdx;
			} else if (A[aIdx] < B[bIdx]) {
				sb.append(A[aIdx]).append(" ");
				++aIdx;
			} else {
				sb.append(A[aIdx]).append(" ").append(B[bIdx]).append(" ");
				++aIdx;
				++bIdx;
			}
		}

		while (aIdx < N) {
			sb.append(A[aIdx]).append(" ");
			++aIdx;
		}

		while (bIdx < M) {
			sb.append(B[bIdx]).append(" ");
			++bIdx;
		}

		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] A = new int[N];

		int M = Integer.parseInt(st.nextToken());
		int[] B = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; ++i) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		twoPointer(N, M, A, B);
	}
}
