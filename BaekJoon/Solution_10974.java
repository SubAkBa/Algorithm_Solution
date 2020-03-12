import java.util.*;
import java.io.*;

public class Solution_10974 {
	static BufferedWriter bw;

	public static void Permutation(int N, LinkedList<Integer> list, boolean[] visited) throws IOException {
		if (list.size() == N) {
			for (int num : list)
				bw.write(num + " ");
			bw.newLine();
			
			return;
		}

		for (int i = 0; i < N; i++) {
			if(visited[i])
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
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		boolean[] visited = new boolean[N];
		LinkedList<Integer> list = new LinkedList<>();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++)
			arr[i] = i + 1;

		Permutation(N, list, visited);
		
		bw.flush();
		bw.close();
		br.close();
	}

}
