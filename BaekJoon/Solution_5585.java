import java.util.*;
import java.io.*;

public class greedy_5585_solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int money = Integer.parseInt(br.readLine());
		int change = 1000 - money, count = 0, idx = 0;
		int[] coins = {500, 100, 50, 10, 5, 1};
		
		while(change > 0) {
			count += change / coins[idx];
			change %= coins[idx];
			idx++;
		}
		
		System.out.println(count);
		
		bw.flush();
		bw.close();
		br.close();
	}

}
