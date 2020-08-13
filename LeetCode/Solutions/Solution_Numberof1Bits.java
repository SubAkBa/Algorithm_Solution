
public class Solution_Numberof1Bits {
	public static int hammingWeight(int n) {
		int count = 0;
		
		while(n != 0) {
			++count;
			n -= (n & -n);
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(hammingWeight(-3));
	}
}
