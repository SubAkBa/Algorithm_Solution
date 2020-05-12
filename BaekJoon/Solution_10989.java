import java.io.*;

public class Solution_10989 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine()), MAX = 10000;
		int[] count = new int[MAX + 1];

		for (int i = 0; i < N; i++)
			count[Integer.parseInt(br.readLine())]++;

		for (int i = 1; i <= MAX; i++) {
			for (int j = 0; j < count[i]; j++)
				bw.write(i + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
