import java.util.*;
import java.io.*;

public class Solution_2884 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int aH = H;
		int aM = ((M = M - 45) < 0) ? 60 + M : M;
		
		if(aM > M) {
			if(aH == 0)
				aH = 23;
			else
				aH--;
		}

		
		bw.write(aH + " " + aM);
		bw.flush();
		bw.close();
		br.close();
	}

}
