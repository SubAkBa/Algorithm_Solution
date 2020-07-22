
public class Solution_NumberofGoodPairs {
	public static int numIdenticalPairs(int[] nums) {
		int len = 101, nlen = nums.length;
		int[] counts = new int[len];

		for (int i = 0; i < nlen; ++i)
			++counts[nums[i]];

		int answer = 0;
		for (int i = 1; i < len; ++i) {
			if (counts[i] >= 2) {
				--counts[i];
				answer += (counts[i] * (counts[i] + 1) / 2);
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(numIdenticalPairs(new int[] { 1, 2, 3, 1, 1, 3 }));
		System.out.println(numIdenticalPairs(new int[] { 1, 1, 1, 1 }));
		System.out.println(numIdenticalPairs(new int[] { 1, 2, 3 }));
	}

}
