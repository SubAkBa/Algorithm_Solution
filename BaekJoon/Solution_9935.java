import java.io.*;

public class Solution_9935 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		String bomb = br.readLine();

		int len = str.length(), blen = bomb.length();
		int cidx = -1, bidx = 0;
		int[] bidxs = new int[len];
		char[] ch = new char[len];

		for (int i = 0; i < len; i++) {
			char s = str.charAt(i);

			ch[++cidx] = s;

			bidx = (cidx == 0 ? 0 : bidxs[cidx - 1]);

			char b = bomb.charAt(bidx);

			if (ch[cidx] != b) {
				bidxs[cidx] = 0;
				
				if (ch[cidx] == bomb.charAt(0))
					bidxs[cidx]++;
				
			} else {
				bidxs[cidx] = ++bidx;

				if (bidxs[cidx] == blen)
					cidx -= blen;
			}
		}

		bw.write((cidx == -1) ? "FRULA" : String.valueOf(ch, 0, cidx + 1) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
