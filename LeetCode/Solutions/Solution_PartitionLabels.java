import java.util.*;

public class Solution_PartitionLabels {

//	public static List<Integer> partitionLabels(String S) {
//		List<Integer> answer = new ArrayList<>();
//
//		int size = 26, slen = S.length();
//		int[] lastidx = new int[size];
//
//		for (int i = 0; i < slen; ++i)
//			lastidx[S.charAt(i) - 'a'] = i;
//
//		int start = 0, temp_last = 0;
//		for (int i = 0; i < slen; ++i) {
//			temp_last = Math.max(temp_last, lastidx[S.charAt(i) - 'a']);
//
//			if (temp_last == i) {
//				answer.add(i - start + 1);
//				start = i + 1;
//			}
//		}
//
//		return answer;
//	}

	public static List<Integer> partitionLabels(String S) {
		List<Integer> answer = new ArrayList<>();

		int len = S.length(), size = 26;

		int[][] pos = new int[size][2];

		for (int i = 0; i < size; ++i)
			Arrays.fill(pos[i], Integer.MAX_VALUE);

		for (int i = 0; i < len; ++i) {
			if (pos[S.charAt(i) - 'a'][0] == Integer.MAX_VALUE)
				pos[S.charAt(i) - 'a'][0] = i;

			pos[S.charAt(i) - 'a'][1] = i;
		}

		Arrays.sort(pos, (a, b) -> Integer.compare(a[0], b[0]));

		int idx = 0;
		int[] temp_pos = pos[0];
		while (idx < size && pos[idx][0] != Integer.MAX_VALUE) {

			while (idx < size && temp_pos[1] >= pos[idx][0]) {
				temp_pos[1] = Math.max(temp_pos[1], pos[idx][1]);
				++idx;
			}

			answer.add(temp_pos[1] - temp_pos[0] + 1);

			if (idx < size)
				temp_pos = pos[idx];
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(partitionLabels("ababcbacadefegdehijhklij")); // [9,7,8]
		System.out.println(partitionLabels("a")); // [1]
		System.out.println(partitionLabels("eaaaabaaec")); // [9,1]
	}
}
