import java.io.*;

public class Solution_2579 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int S = Integer.parseInt(br.readLine());
		int[] stair = new int[301], total = new int[301];

		for (int i = 0; i < S; i++)
			stair[i] = Integer.parseInt(br.readLine());
		
		total[0] = stair[0];
		total[1] = stair[0] + stair[1];
		total[2] = Math.max(stair[0] + stair[2], stair[1] + stair[2]);

		for (int i = 3; i < S; i++)
			total[i] = Math.max(total[i - 2] + stair[i], total[i - 3] + stair[i - 1] + stair[i]);

		bw.write(total[S - 1] + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
