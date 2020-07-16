
public class Solution_RangeSumQuery_Mutable {

	public static class NumArray {
		int[] tree;
		int len;
		int[] nums;

		public NumArray(int[] nums) {
			this.len = nums.length;
			this.tree = new int[AllocSize()];
			this.nums = nums;

			if (len > 0)
				InitFunc(nums, 0, len - 1, 1);
		}

		private int AllocSize() {
			return (int) Math.pow(2, Math.ceil(Math.log(len) / Math.log(2)) + 1);
		}

		private int InitFunc(int[] nums, int start, int end, int node) {
			if (start == end)
				return tree[node] = nums[start];

			int mid = (start + end) >> 1;

			return tree[node] = InitFunc(nums, start, mid, node << 1) + InitFunc(nums, mid + 1, end, (node << 1) + 1);
		}

		public void update(int i, int val) {
			if (len > 0) {
				int diff = val - nums[i];
				nums[i] = val;

				updateQuery(0, len - 1, i, 1, diff);
			}
		}

		private void updateQuery(int start, int end, int idx, int node, int diff) {
			if (!(start <= idx && idx <= end))
				return;

			tree[node] += diff;

			if (start < end) {
				int mid = (start + end) >> 1;

				updateQuery(start, mid, idx, node * 2, diff);
				updateQuery(mid + 1, end, idx, node * 2 + 1, diff);
			}
		}

		public int sumRange(int i, int j) {

			return sumQuery(0, len - 1, i, j, 1);
		}

		private int sumQuery(int start, int end, int left, int right, int node) {
			if (right < start || left > end)
				return 0;

			if (left <= start && end <= right)
				return tree[node];

			int mid = (start + end) >> 1;

			return sumQuery(start, mid, left, right, node * 2) + sumQuery(mid + 1, end, left, right, node * 2 + 1);
		}
	}

	public static void main(String[] args) {
		NumArray obj = new NumArray(new int[] { 1, 3, 5 });
		System.out.println(obj.sumRange(0, 2)); // 9
		obj.update(1, 2);
		System.out.println(obj.sumRange(0, 2)); // 8
	}

}
