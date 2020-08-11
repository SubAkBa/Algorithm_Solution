import java.util.*;

public class Solution_tuple {
	public static int[] solution(String s) {
		String[] list = s.substring(2, s.length() - 2).split("\\},\\{");
		HashSet<Integer> hs = new HashSet<>();
		int len = list.length, idx = 0;
		int[] answer = new int[len];

		Arrays.sort(list, (a, b) -> {
			return a.length() - b.length();
		});

		for (String str : list) {
			StringTokenizer st = new StringTokenizer(str, ",");

			while (st.hasMoreTokens()) {
				int n = Integer.parseInt(st.nextToken());

				if (!hs.contains(n)) {
					hs.add(n);
					answer[idx++] = n;
				}

			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
		System.out.println(Arrays.toString(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
		System.out.println(Arrays.toString(solution("{{20,111},{111}}")));
		System.out.println(Arrays.toString(solution("{{123}}")));
		System.out.println(Arrays.toString(solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
	}

}
