import java.util.*;
import java.io.*;

public class simulation_1057_solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int person = Integer.parseInt(st.nextToken());
		int jimin = Integer.parseInt(st.nextToken());
		int hansoo = Integer.parseInt(st.nextToken());
		int round = 0;
		
		while(jimin != hansoo) {
			jimin = (int)Math.round(jimin / 2 + jimin % 2);
			hansoo = (int)Math.round(hansoo / 2 + hansoo % 2);
			
			round++;
		}
		
		bw.write(round + " ");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
