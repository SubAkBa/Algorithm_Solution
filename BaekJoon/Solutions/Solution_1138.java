import java.util.*;
import java.io.*;

public class Solution_1138 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] count = new int[N];
		LinkedList<Integer> answer = new LinkedList<>();

		for (int i = 0; i < N; i++)
			count[i] = Integer.parseInt(st.nextToken());

		for (int i = N - 1; i >= 0; i--)
			answer.add(count[i], (i + 1));

		for (int i = 0; i < N; i++)
			bw.write(answer.get(i) + " ");

		bw.flush();
		bw.close();
		br.close();
	}

}
