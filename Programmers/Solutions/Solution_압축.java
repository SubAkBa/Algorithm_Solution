import java.util.*;

public class Solution_압축 {

	public static int[] solution(String msg) {
		int len = msg.length();
		List<Integer> idxlist = new ArrayList<>();
		Map<String, Integer> table = new HashMap<>();

		for (int i = 0; i < 26; ++i)
			table.put(String.valueOf((char) (i + 'A')), i + 1);

		int idx = 26, pos = 0;
		while (pos < len) {
			StringBuilder part = new StringBuilder();
			part.append(msg.charAt(pos));

			int start = pos;
			while (table.containsKey(part.toString())) {
				++pos;

				if (pos == len)
					break;

				part.append(msg.charAt(pos));
			}

			if (start == pos)
				++pos;

			idxlist.add(table.get(msg.substring(start, pos)));

			if (!table.containsKey(part.toString()))
				table.put(part.toString(), ++idx);
		}

		int size = idxlist.size();
		int[] answer = new int[size];

		for (int i = 0; i < size; ++i)
			answer[i] = idxlist.get(i);

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("KAKAO"))); // [11, 1, 27, 15]
		System.out.println(Arrays.toString(solution("TOBEORNOTTOBEORTOBEORNOT"))); // [20, 15, 2, 5, 15, 18, 14, 15, 20,
																					// 27, 29, 31, 36, 30, 32, 34]
		System.out.println(Arrays.toString(solution("ABABABABABABABAB"))); // [1, 2, 27, 29, 28, 31, 30]
	}
}
