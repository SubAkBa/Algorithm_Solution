import java.util.*;
import java.io.*;
import java.math.*;

public class Solution_2407 {
	static BigInteger[][] result;
	
	public static BigInteger Combination(int n, int m) {
		if(m == 0 || n == m)
			return result[n][m] = BigInteger.ONE;
		
		if(result[n][m] != null)
			return result[n][m];
		
		result[n][m] = new BigInteger("0");
		
		return result[n][m] = result[n][m].add(Combination(n - 1, m).add(Combination(n - 1, m - 1)));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		result = new BigInteger[n + 1][n + 1];
		
		if((n - m) < m)
			m = n - m;
		
		bw.write(Combination(n, m) + " ");
		
		bw.flush();
		bw.close();
		br.close();
	}

}
