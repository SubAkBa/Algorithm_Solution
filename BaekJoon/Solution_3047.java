import java.util.*;
import java.io.*;

public class Solution_3047 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int LEN = 3;
		int[] nums = new int[LEN];
		for (int i = 0; i < LEN; i++)
			nums[i] = Integer.parseInt(st.nextToken());

		String str = br.readLine();

		Arrays.sort(nums);

		for (int i = 0; i < LEN; i++)
			bw.write(nums[str.charAt(i) - 'A'] + " ");

		bw.flush();
		bw.close();
		br.close();
	}

}
