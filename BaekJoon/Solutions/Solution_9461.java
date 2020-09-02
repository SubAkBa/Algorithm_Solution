import java.io.*;

public class Solution_9461 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		long[] nums = new long[101];
		nums[1] = nums[2] = nums[3] = 1;

		while ((T--) > 0) {
			int N = Integer.parseInt(br.readLine());

			if (nums[N] != 0)
				bw.write(nums[N] + "\n");
			else {
				for (int i = 4; i <= N; i++)
					nums[i] = nums[i - 2] + nums[i - 3];
				bw.write(nums[N] + "\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
