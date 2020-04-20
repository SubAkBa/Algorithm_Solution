import java.util.*;
import java.io.*;

public class Solution_11053 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine()), max = 0;
		int[] nums = new int[N], lens = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			lens[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i])
					lens[i] = Math.max(lens[j] + 1, lens[i]);
			}
			
			max = Math.max(max, lens[i]);
		}
		bw.write(max + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
