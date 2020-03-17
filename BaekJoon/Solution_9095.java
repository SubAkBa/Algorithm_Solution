import java.io.*;

public class Solution_9095 {
	static int[] count;
	
	public static int ExpressionSum(int n) {
		if(n < 0)
			return 0;
		
		if(n == 0)
			return count[n] = 1;
		
		if(count[n] != 0)
			return count[n];
		
		return count[n] = ExpressionSum(n - 1) + ExpressionSum(n - 2) + ExpressionSum(n - 3); 
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while ((T--) > 0) {
			int n = Integer.parseInt(br.readLine());
			count = new int[n + 1];
			
			ExpressionSum(n);
			
			sb.append(count[n] + "\n");
		}
		
		bw.write(sb.toString() + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
