import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution_20437 {

	public static int[] slidingWindow(String str, int K) {
		char[] charArray = str.toCharArray();
		List<Integer>[] positionList = new ArrayList[26];

		for (int i = 0; i < 26; ++i) {
			positionList[i] = new ArrayList<>();
		}

		for (int i = 0; i < charArray.length; ++i) {
			positionList[charArray[i] - 'a'].add(i);
		}

		int minLen = Integer.MAX_VALUE, maxLen = 0;
		for (List<Integer> positions : positionList) {
			if (positions.size() < K) {
				continue;
			}

			for (int j = 0; j + K - 1 < positions.size(); ++j) {
				int len = positions.get(j + K - 1) - positions.get(j) + 1;

				minLen = Math.min(minLen, len);
				maxLen = Math.max(maxLen, len);
			}
		}

		return new int[] {minLen, maxLen};
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while ((--T) >= 0) {
			String str = br.readLine();
			int K = Integer.parseInt(br.readLine());

			int[] answer = slidingWindow(str, K);

			if (answer[0] == Integer.MAX_VALUE) {
				sb.append(-1).append("\n");
			} else {
				sb.append(answer[0]).append(" ").append(answer[1]).append("\n");
			}
		}

		System.out.println(sb);
	}
}
