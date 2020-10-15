import java.util.*;

public class Solution_MaximumLengthofaConcatenatedStringwithUniqueCharacters {
	static int answer, ALPHABET = 26;

	public boolean isRepeated(String s) {
		int temp = 0;
		for (char c : s.toCharArray()) {
			if ((temp & (1 << c - 'a')) != 0)
				return true;

			temp |= (1 << c - 'a');
		}

		return false;
	}

	public boolean isExisted(int key, String s) {
		for (char c : s.toCharArray()) {
			if ((key & (1 << c - 'a')) != 0)
				return true;
		}

		return false;
	}

	public int addKey(int key, String s) {
		for (char c : s.toCharArray())
			key |= 1 << (c - 'a');

		return key;
	}

	public void DFS(List<String> arr, int idx, int len, int curlen, int key) {
		if (idx == len) {
			answer = Math.max(answer, curlen);
			return;
		}

		String s = arr.get(idx);

		if (!isRepeated(s) && !isExisted(key, s))
			DFS(arr, idx + 1, len, curlen + s.length(), addKey(key, s));
		
		DFS(arr, idx + 1, len, curlen, key);
	}

	public int maxLength(List<String> arr) {
		answer = 0;

		DFS(arr, 0, arr.size(), 0, 0);

		return answer;
	}
}
