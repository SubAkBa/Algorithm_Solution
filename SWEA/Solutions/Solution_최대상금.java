import java.util.*;
import java.io.*;

public class Solution_maxprizemoney {
	static int answer, len;
	static HashSet<String> hs;

	public static void DFS(int[] nums, int change) {
		int val = 0;
		for (int num : nums)
			val = val * 10 + num;

		if (change == 0) {
			answer = Math.max(answer, val);
			return;
		}
		
		if (hs.contains("" + val + change))
			return;
		else
			hs.add("" + val + change);

		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				Swap(nums, i, j);
				DFS(nums, change - 1);
				Swap(nums, i, j);
			}
		}
	}

	public static void Swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine()), count = 0;

		while ((count++) < T) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			len = s.length();
			answer = 0;
			hs = new HashSet<>();
			int[] nums = new int[len];
			int change = Integer.parseInt(st.nextToken());

			for (int i = 0; i < len; i++)
				nums[i] = s.charAt(i) - '0';

			DFS(nums, change);

			bw.write("#" + count + " " + answer + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
