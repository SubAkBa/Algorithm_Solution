import java.util.*;
import java.io.*;

public class Solution_1427 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] chr = br.readLine().toCharArray();

		Arrays.sort(chr);

		for (int i = chr.length - 1; i >= 0; i--)
			bw.write(chr[i]);

		bw.flush();
		bw.close();
		br.close();
	}

}
