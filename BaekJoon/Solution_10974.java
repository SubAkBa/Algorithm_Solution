import java.util.*;
import java.io.*;

public class main {
	static StringBuilder sb;

	public static void Permutation(int N, LinkedList<Integer> list, boolean[] visited) throws IOException {
		if (list.size() == N) {
			for (int num : list)
				sb.append(num + " ");
			sb.append("\n");

			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;

			visited[i] = true;
			list.add(i + 1);

			Permutation(N, list, visited);

			visited[i] = false;
			list.removeLast();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		boolean[] visited = new boolean[N];
		LinkedList<Integer> list = new LinkedList<>();

		Permutation(N, list, visited);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
