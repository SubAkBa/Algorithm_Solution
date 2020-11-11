
public class Solution_VerifyPreorderSerializationofaBinaryTree {

	public static boolean isValidSerialization(String preorder) {
		int outdeg = -1;
		String[] str = preorder.split(",");

		for (String s : str) {
			++outdeg;

			if (outdeg > 0)
				return false;

			if (!s.equals("#"))
				outdeg -= 2;
		}

		return outdeg == 0;
	}

	public static void main(String[] args) {
		System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#")); // true
		System.out.println(isValidSerialization("1,#")); // false
		System.out.println(isValidSerialization("9,#,#,1")); // false
	}
}
