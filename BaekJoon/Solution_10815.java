import java.util.*;
import java.io.*;

public class Solution_10815 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		for (int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(nums);

		int M = Integer.parseInt(br.readLine());
		int[] cards = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++)
			cards[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < M; i++) {
			int left = 0;
			int right = N - 1;
			boolean found = false;

			while (left <= right) {
				int mid = (left + right) / 2;
				
				if (cards[i] == nums[mid]) {
					found = true;
					break;
				} else if (cards[i] > nums[mid])
					left = mid + 1;
				else
					right = mid - 1;
			}
			
			if(found)
				bw.write("1 ");
			else
				bw.write("0 ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
