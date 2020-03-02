import java.util.*;
import java.io.*;

public class stringprocess_10988_solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder(br.readLine());
		
		if(sb.toString().equals(sb.reverse().toString()))
			bw.write("1 ");
		else
			bw.write("0 ");
		
		bw.flush();
		bw.close();
		br.close();
	}

}
