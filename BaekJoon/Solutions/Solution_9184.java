import java.io.*;

public class Source {
	static final int RANGE = 20;
	static int[][][] dp;
	
	public static int w(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
		
		if (a > RANGE || b > RANGE || c > RANGE) {
			return w(RANGE, RANGE, RANGE);
		}
		
		if (dp[a][b][c] != 0) {
			return dp[a][b][c];
		}
		
		if (a < b && b < c) {
			return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		}
		
		return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
	}

    public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		dp = new int[RANGE + 1][RANGE + 1][RANGE + 1];
		
		while (true) {
			String[] str = br.readLine().split(" ");
			
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			int c = Integer.parseInt(str[2]);
			
			if (a == -1 && b == -1 && c == -1)
				break;
			
			bw.write(String.format("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c)));
		}
		
		bw.flush();
		bw.close();
		br.close();
    }
}



