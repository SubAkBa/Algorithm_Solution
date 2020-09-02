import java.util.*;
import java.io.*;

public class dfs_6603_solution {
	static StringBuilder sb;

	public static void DFS(int[] lotto, ArrayList<Integer> output, int start, int depth) {

		if (depth == 6) {
			for (int i = 0; i < output.size(); i++)
				sb.append(output.get(i) + " ");
			sb.append("\n");

			return;
		}

		for (int i = start; i < lotto.length; i++) {
			output.add(lotto[i]);
			DFS(lotto, output, i + 1, depth + 1);
			output.remove(output.size() - 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] lotto;
		ArrayList<Integer> output = new ArrayList<Integer>();
		sb = new StringBuilder();

		while (true) {
			String[] test = br.readLine().split(" ");
			
			if (test[0].equals("0"))
				break;
			else {
				lotto = new int[Integer.parseInt(test[0])];

				for (int i = 0; i < lotto.length; i++)
					lotto[i] = Integer.parseInt(test[i + 1]);

				DFS(lotto, output, 0, 0);
				
				sb.append("\n");
			}
		}
		
		System.out.print(sb.toString());
	}

}
