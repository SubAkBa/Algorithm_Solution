import java.io.*;

public class Solution_9095 {
	static int[] count;
	
	public static int ExpressionSum(int n) {
		if(n < 0)
			return 0;
		
		if(count[n] != 0)
			return count[n];
		
		return count[n] = ExpressionSum(n - 1) + ExpressionSum(n - 2) + ExpressionSum(n - 3); 
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		while ((T--) > 0) {
			int n = Integer.parseInt(br.readLine());
			count = new int[n + 1];
			
			count[1] = 1;
			count[2] = 2;
			count[3] = 4;
			
			ExpressionSum(n);
			
			bw.write(count[n] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
