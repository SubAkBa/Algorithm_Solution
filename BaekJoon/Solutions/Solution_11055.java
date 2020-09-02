import java.util.*;
import java.io.*;

public class Solution_11055 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine()), answer = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[N], sum = new int[N];
		for (int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			int max = 0;
			sum[i] = nums[i];
			
			for (int j = 0; j < i; j++) {
				if(nums[j] < nums[i])
					max = Math.max(max, sum[j]);
			}
			sum[i] += max;
			answer = Math.max(sum[i], answer);
		}
		
		bw.write(answer + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
