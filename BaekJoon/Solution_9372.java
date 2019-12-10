import java.util.*;
import java.io.*;

public class Solution_9372 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int testcase = Integer.parseInt(br.readLine());

		for (int i = 0; i < testcase; i++) {
			st = new StringTokenizer(br.readLine());

			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			for (int j = 0; j < E; j++)
				br.readLine();
			
			bw.write(V - 1 + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
