import java.util.*;
import java.io.*;

public class Solution_2263 {

	public static void GetPreOrder(List<Integer> preorder, int[] postorder, int[] idx, int in_left, int in_right,
			int post_left, int post_right) {
		if (in_left > in_right || post_left > post_right)
			return;

		int root_idx = idx[postorder[post_right]];

		preorder.add(postorder[post_right]);

		GetPreOrder(preorder, postorder, idx, in_left, root_idx - 1, post_left, post_left + root_idx - in_left - 1);
		GetPreOrder(preorder, postorder, idx, root_idx + 1, in_right, post_left + root_idx - in_left, post_right - 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] inorder = new int[n + 1];
		int[] postorder = new int[n + 1];
		int[] idx = new int[n + 1];
		List<Integer> preorder = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; ++i)
			inorder[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; ++i)
			postorder[i] = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= n; ++i)
			idx[inorder[i]] = i;

		GetPreOrder(preorder, postorder, idx, 1, n, 1, n);

		for (int node : preorder)
			bw.write(node + " ");

		bw.flush();
		bw.close();
		br.close();
	}
}
