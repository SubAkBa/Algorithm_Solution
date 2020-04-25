import java.util.*;

public class Solution_ZigZagConversion {
	public static String convert(String s, int numRows) {
		StringBuilder sb = new StringBuilder();
		int len = s.length();
		int cyclelen = 2 * (numRows - 1);

		if (numRows == 1)
			return s;

		for (int i = 0; i < numRows; i++) {
			int idx = 0;

			while (idx + i < len) {
				int temp = idx + cyclelen - i;
				sb.append(s.charAt(idx + i));

				if (i != 0 && i != numRows - 1 && temp < len)
					sb.append(s.charAt(temp));

				idx += cyclelen;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 2));
		System.out.println(convert("PAYPALISHIRING", 3));
		System.out.println(convert("PAYPALISHIRING", 4));
	}

}
