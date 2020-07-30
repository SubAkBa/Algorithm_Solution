
public class Solution_DetectCapital {
	public static boolean detectCapitalUse(String word) {
		boolean isCapital = true, isUpper = false, isLower = false;
		boolean isAllLower = false;
		char[] ch = word.toCharArray();

		for (char c : ch) {
			if (isAllLower && 'A' <= c && c <= 'Z')
				return false;

			if (isCapital) {
				isCapital = false;

				if ('a' <= c && c <= 'z')
					isAllLower = true;
			} else {

				if (isUpper && 'a' <= c && c <= 'z')
					return false;

				if ('A' <= c && c <= 'Z') {
					if (isAllLower || isLower)
						return false;
					else
						isUpper = true;
				} else {
					if (isUpper)
						return false;
					else
						isLower = true;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(detectCapitalUse("USA"));
		System.out.println(detectCapitalUse("FlaG"));
	}

}
