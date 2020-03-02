import java.util.*;
import java.io.*;
import java.math.*;

public class combination_2407_solution {
	static BigInteger[][] comb;
	
	public static BigInteger Combination(int n, int m) {
		
		if(m == 0 || n == m)
			return BigInteger.ONE;
		
		if(comb[n][m] != null)
			return comb[n][m];
		
		comb[n][m] = new BigInteger("0");
		
		return comb[n][m] = comb[n][m].add(Combination(n - 1, m)).add(Combination(n - 1, m - 1));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] inputs = br.readLine().split(" ");
		
		int max = Math.max(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
		
		comb = new BigInteger[max + 1][max + 1];
		
		System.out.println(Combination(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1])));
	}

}