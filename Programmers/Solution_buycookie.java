
public class Solution_buycookie {

	public static int AllocSize(int num) {
		return (int) Math.pow(2, (int) Math.ceil(Math.log(num) / Math.log(2)) + 1);
	}

	public static int Init(int[] cookie, int[] tree, int start, int end, int node) {
		if (start == end)
			return tree[node] = cookie[start];

		int mid = (start + end) / 2;

		return tree[node] = Init(cookie, tree, start, mid, node * 2) + Init(cookie, tree, mid + 1, end, node * 2 + 1);
	}

	public static int Query(int[] tree, int start, int end, int left, int right, int node) {
		if (right < start || left > end)
			return 0;

		if (left <= start && end <= right)
			return tree[node];

		int mid = (start + end) / 2;

		return Query(tree, start, mid, left, right, node * 2) + Query(tree, mid + 1, end, left, right, node * 2 + 1);
	}

	public static int solution(int[] cookie) {
		int answer = 0;
		int len = cookie.length;

		int size = AllocSize(len);
		int[] tree = new int[size];

		Init(cookie, tree, 0, len - 1, 1);

		for (int m = len - 2; m >= 0; m--) {
			int l = 0, r = len - 1;
			int la = Query(tree, 0, len - 1, l, m, 1);
			int ra = Query(tree, 0, len - 1, m + 1, r, 1);

			while (l < r) {
				if (la == ra) {
					answer = Math.max(answer, la);
					break;
				} else if (la > ra) {
					la -= cookie[l];
					l++;
				} else {
					ra -= cookie[r];
					r--;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 1, 2, 3 }));
		System.out.println(solution(new int[] { 1, 2, 4, 5 }));
	}

}
