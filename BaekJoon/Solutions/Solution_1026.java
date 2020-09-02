import java.util.*;
import java.io.*;

public class Solution_1026 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] alist = new int[n];
		int[] blist = new int[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++)
			alist[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++)
			blist[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(alist);
		Arrays.sort(blist);

		int result = 0;

		for (int i = 0; i < n; i++)
			result += alist[i] * blist[n - i - 1];
		
		bw.write(result + " ");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
