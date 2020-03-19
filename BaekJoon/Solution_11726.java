import java.io.*;

public class Solution_11726 {
	static int[] tile;

	public static int Tile(int n) {
		if(n <= 0)
			return 0;
		
		if(tile[n] != 0)
			return tile[n];
		
		return tile[n] = (Tile(n - 1) + Tile(n - 2)) % 10007;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		
		if(n == 1)
			bw.write(1 + " ");
		else if(n == 2)
			bw.write(2 + " ");
		else {
			tile = new int[n + 1];			
			tile[1] = 1;
			tile[2] = 2;
			
			Tile(n);
			bw.write(tile[n] + " ");
		}
		

		bw.flush();
		bw.close();
		br.close();
	}

}
