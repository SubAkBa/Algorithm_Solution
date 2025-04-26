import java.util.HashMap;
import java.util.Map;

public class Solution_ExcelSheetColumnNumber {
	public static int titleToNumber(String columnTitle) {
		Map<Character, Integer> alphaToNumberMap = new HashMap<>();

		for (int i = 0; i < 26; ++i) {
			alphaToNumberMap.put((char)((int)'A' + i), i + 1);
		}

		int len = columnTitle.length();
		int carry = 1;
		int titleNumber = 0;
		for (int i = len - 1; i >= 0; --i) {
			char ch = columnTitle.charAt(i);

			titleNumber += alphaToNumberMap.get(ch) * carry;

			carry *= 26;
		}

		return titleNumber;
	}

	public static void main(String[] args) {
		System.out.println(titleToNumber("A")); // 1
		System.out.println(titleToNumber("AB")); // 28
		System.out.println(titleToNumber("ZY")); // 701
	}
}
