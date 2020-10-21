import java.util.*;

public class Solution_RestoreIPAddresses {

	public static void DFS(List<String> answer, String s, int[] values, int segment, int idx, int len) {
		if (segment == 4 && idx == len) {
			answer.add(values[0] + "." + values[1] + "." + values[2] + "." + values[3]);
			return;
		} else if (segment == 4 || idx == len)
			return;

		for (int i = 1; i < 4 && idx + i <= len; ++i) {
			int value = Integer.parseInt(s.substring(idx, idx + i));

			if (value > 255 || (i >= 2 && s.charAt(idx) == '0'))
				break;

			values[segment] = value;
			DFS(answer, s, values, segment + 1, idx + i, len);
		}
	}

	public static List<String> restoreIpAddresses(String s) {
		List<String> answer = new ArrayList<>();

		DFS(answer, s, new int[4], 0, 0, s.length());

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(restoreIpAddresses("25525511135")); // ["255.255.11.135","255.255.111.35"]
		System.out.println(restoreIpAddresses("0000")); // ["0.0.0.0"]
		System.out.println(restoreIpAddresses("1111")); // ["1.1.1.1"]
		System.out.println(restoreIpAddresses("010010")); // ["0.10.0.10","0.100.1.0"]
		System.out.println(restoreIpAddresses("101023")); // ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
	}
}
