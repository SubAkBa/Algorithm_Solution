import java.io.*;

public class Solution_2775 {

    public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		while ((--T) >= 0) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			int[][] dp = new int[k + 1][n + 1];
			
			for (int i = 0; i <= k; ++i) {
				for (int j = 0; j <= n; ++j) {
					if (i == 0) {
						dp[i][j] = j;
					} else if (j > 0) {
						dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
					}
				}
			}
			
			bw.write(dp[k][n] + "\n");
		}
		
		bw.flush();	
		bw.close();
		br.close();
    }
}



