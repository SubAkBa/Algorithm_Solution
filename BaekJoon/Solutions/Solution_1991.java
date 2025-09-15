import java.io.*;
import java.util.StringTokenizer;

public class Solution_1991 {
	static int[][] treeArr;

	public static void preOrder(int node) {
		System.out.print((char) (node + 'A'));

		if (treeArr[node][0] != -1) {
			preOrder(treeArr[node][0]);
		}

		if (treeArr[node][1] != -1) {
			preOrder(treeArr[node][1]);
		}
	}

	public static void inOrder(int node) {
		if (treeArr[node][0] != -1) {
			inOrder(treeArr[node][0]);
		}

		System.out.print((char)(node + 'A'));

		if (treeArr[node][1] != -1) {
			inOrder(treeArr[node][1]);
		}
	}

	public static void postOrder(int node) {
		if (treeArr[node][0] != -1) {
			postOrder(treeArr[node][0]);
		}

		if (treeArr[node][1] != -1) {
			postOrder(treeArr[node][1]);
		}

		System.out.print((char)(node + 'A'));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		treeArr = new int[N + 1][2];

		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine());

			int node = st.nextToken().charAt(0) - 'A';
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);

			if (left != '.') {
				treeArr[node][0] = left - 'A';
			} else {
				treeArr[node][0] = -1;
			}

			if (right != '.') {
				treeArr[node][1] = right - 'A';
			} else {
				treeArr[node][1] = -1;
			}
		}

		preOrder(0);
		System.out.println();
		inOrder(0);
		System.out.println();
		postOrder(0);
	}
}