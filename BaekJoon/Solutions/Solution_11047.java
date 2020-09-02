import java.util.*;
import java.io.*;

public class greedy_11047_solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int money = Integer.parseInt(st.nextToken());
		int[] coins = new int[N];
		int count = 0, idx = 0;

		for (int i = N - 1; i >= 0; i--)
			coins[i] = Integer.parseInt(br.readLine());
		
		while(money > 0) {
			
			count += money / coins[idx];
			money %= coins[idx];
			
			idx++;
		}
		
		System.out.println(count);
		
		bw.flush();
		bw.close();
		br.close();
	}
}
