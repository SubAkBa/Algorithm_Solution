import java.util.*;
import java.io.*;

public class greedy_2217_solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] rope = new int[N];
		int weight = 0;

		for (int i = 0; i < N; i++)
			rope[i] = Integer.parseInt(br.readLine());

		Arrays.sort(rope);

		for (int i = N - 1; i >= 0; i--)
			weight = Math.max(weight, rope[i] * (N - i));
		
        bw.write(weight + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
