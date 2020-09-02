import java.io.*;

public class Solution_12813 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] A = br.readLine().toCharArray();
		char[] B = br.readLine().toCharArray();

		StringBuilder sb = new StringBuilder();
		int len = A.length;
		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < len; i++) {
				switch(j) {
				case 0:
					sb.append((A[i] - '0') & (B[i] - '0'));
					break;
				case 1:
					sb.append((A[i] - '0') | (B[i] - '0'));
					break;
				case 2:
					sb.append((A[i] - '0') ^ (B[i] - '0'));
					break;
				case 3:
					sb.append((A[i] - '0') ^ 1);
					break;
				case 4:
					sb.append((B[i] - '0') ^ 1);
					break;
				}
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
