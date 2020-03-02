import java.util.*;
import java.io.*;

public class stringprocess_2908_solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringBuilder left = new StringBuilder(st.nextToken());
		StringBuilder right = new StringBuilder(st.nextToken());
		
		bw.write(Math.max(
				Integer.parseInt(left.reverse().toString()), 
				Integer.parseInt(right.reverse().toString())) + " ");
		
		bw.flush();
		bw.close();
		br.close();
	}

}
