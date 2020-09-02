import java.util.*;
import java.io.*;

public class Solution_2110 {
	static int N, C;

	public static int Install_Wifi(int[] home) {
		int left = 1, right = home[N - 1] - home[0], answer = 0;

		while (left <= right) {
			int mid = (left + right) / 2;
			int start = home[0], count = 1;

			for (int i = 1; i < N; i++) {
				int dist = home[i] - start;

				if (mid <= dist) {
					count++;
					start = home[i];
				}
			}
			
			if(count >= C) {
				answer = mid;
				left = mid + 1;
			}
			else
				right = mid - 1;
		}
		
		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		int[] home = new int[N];

		for (int i = 0; i < N; i++)
			home[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(home);

		bw.write(Install_Wifi(home) + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
