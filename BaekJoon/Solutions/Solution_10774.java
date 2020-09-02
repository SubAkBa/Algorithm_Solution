import java.util.*;
import java.io.*;

public class Solution_10774 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int J = Integer.parseInt(br.readLine());
		int A = Integer.parseInt(br.readLine());

		char[] jersey = new char[J + 1];

		for (int i = 1; i <= J; i++)
			jersey[i] = br.readLine().charAt(0);

		int count = 0;
		for (int i = 0; i < A; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char size = st.nextToken().charAt(0);
			int num = Integer.parseInt(st.nextToken());

			if (jersey[num] != 'A') {
				switch (size) {
				case 'S':
					jersey[num] = 'A';
					count++;
					break;
				case 'M':
					if (jersey[num] == 'M' || jersey[num] == 'L') {
						jersey[num] = 'A';
						count++;
					}
					break;
				case 'L':
					if (jersey[num] == 'L') {
						jersey[num] = 'A';
						count++;
					}
					break;
				}
			}
		}
		bw.write(count + " ");
		bw.flush();
		bw.close();
		br.close();
	}
}
