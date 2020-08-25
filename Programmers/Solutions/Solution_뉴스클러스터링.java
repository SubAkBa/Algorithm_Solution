import java.util.*;

public class Solution_뉴스클러스터링 {

	public static int solution(String str1, String str2) {
		List<String> str1_list = new ArrayList<>();
		List<String> str2_list = new ArrayList<>();
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();

		int len1 = ch1.length, len2 = ch2.length;
		Map<String, Integer> map = new HashMap<>();

		for (int i = 1; i < len1; ++i) {
			if (!Character.isAlphabetic(ch1[i - 1]) || !Character.isAlphabetic(ch1[i]))
				continue;

			String temp = String.valueOf(ch1, i - 1, 2).toLowerCase();
			str1_list.add(temp);
			map.put(temp, map.getOrDefault(temp, 0) + 1);
		}

		for (int i = 1; i < len2; ++i) {
			if (!Character.isAlphabetic(ch2[i - 1]) || !Character.isAlphabetic(ch2[i]))
				continue;

			str2_list.add(String.valueOf(ch2, i - 1, 2).toLowerCase());
		}

		int size2 = str2_list.size();
		int n1 = 0, n2 = str1_list.size() + size2;

		for (int i = 0; i < size2; ++i) {
			if (map.containsKey(str2_list.get(i)) && map.get(str2_list.get(i)) > 0) {
				map.put(str2_list.get(i), map.get(str2_list.get(i)) - 1);
				--n2;
				++n1;
			}
		}

		double answer = (n1 == 0 && n2 == 0 ? 1 : (double) n1 / n2);

		return (int) (answer * 65536);
	}

	public static void main(String[] args) {
		System.out.println(solution("FRANCE", "french"));
		System.out.println(solution("handshake", "shake hands"));
		System.out.println(solution("aa1+aa2", "AAAA12"));
		System.out.println(solution("E=M*C^2", "e=m*c^2"));
	}

}
