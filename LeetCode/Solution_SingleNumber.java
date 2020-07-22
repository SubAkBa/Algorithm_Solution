
public class Solution_SingleNumber {

	public static int singleNumber(int[] nums) {
		int space = 0;

		for (int n : nums)
			space ^= n;

		return space;
	}

	public static void main(String[] args) {
		System.out.println(singleNumber(new int[] { 2, 2, 1 }));
		System.out.println(singleNumber(new int[] { 4, 1, 2, 1, 2 }));
	}

}
