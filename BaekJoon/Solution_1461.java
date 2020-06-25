import java.util.*;
import java.io.*;

public class Solution_1461 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int[] minus_books = new int[N];
		int[] plus_books = new int[N];
		int total = 0, midx = 0, pidx = 0;

		for (int i = 0; i < N; i++) {
			int book = Integer.parseInt(st.nextToken());

			if (book > 0)
				plus_books[pidx++] = -book;
			else
				minus_books[midx++] = book;
		}

		Arrays.sort(minus_books);
		Arrays.sort(plus_books);

		int pmax = -plus_books[0];
		for (int i = 0; i < pidx; i += M)
			total += Math.abs(plus_books[i]) * 2;

		int mmax = -minus_books[0];
		for (int i = 0; i < midx; i += M)
			total += Math.abs(minus_books[i]) * 2;

		if (mmax > pmax)
			total -= mmax;
		else
			total -= pmax;

		bw.write(total + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
