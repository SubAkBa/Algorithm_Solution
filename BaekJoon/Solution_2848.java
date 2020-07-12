import java.util.*;
import java.io.*;

public class Solution_2848 {
	static int N, type, SIZE = 26;
	static int[] indeg;
	static String[] str;
	static HashSet<Character> set;
	static ArrayList<Integer>[] adj;

	public static String Topological_Sort() {
		Queue<Integer> queue = new LinkedList<>();
		Iterator<Character> iter = set.iterator();
		boolean emark = false, qmark = false;
		StringBuilder sb = new StringBuilder();

		while (iter.hasNext()) {
			int idx = iter.next() - 'a';

			if (indeg[idx] == 0)
				queue.offer(idx);
		}

		for (int i = 0; i < type; ++i) {
			if (queue.isEmpty()) {
				emark = true;
				break;
			}

			if (queue.size() > 1)
				qmark = true;

			int from = queue.poll();

			sb.append((char) (from + 'a'));

			for (int to : adj[from]) {
				if ((--indeg[to]) == 0)
					queue.offer(to);
			}

		}

		if (emark)
			return "!";
		else if (qmark)
			return "?";

		return sb.toString();
	}

	public static boolean SetEdge() {
		for (int i = 0; i < N; ++i) {
			char[] ch = str[i].toCharArray();

			for (char c : ch) {
				if (!set.contains(c)) {
					set.add(c);
					++type;
				}
			}
		}

		for (int i = 1; i < N; ++i) {
			int len = Math.min(str[i - 1].length(), str[i].length());

			for (int j = 0; j < len; ++j) {
				char a = str[i - 1].charAt(j);
				char b = str[i].charAt(j);

				if (a != b) {
					adj[a - 'a'].add(b - 'a');
					++indeg[b - 'a'];
					break;
				}

				if (j == len - 1 && str[i - 1].length() > str[i].length())
					return false;
			}
		}

		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		type = 0;
		str = new String[N];

		set = new HashSet<>();
		indeg = new int[SIZE];
		adj = new ArrayList[SIZE];

		for (int i = 0; i < SIZE; ++i)
			adj[i] = new ArrayList<>();

		for (int i = 0; i < N; ++i)
			str[i] = br.readLine();

		if (SetEdge())
			bw.write(Topological_Sort() + "");
		else
			bw.write("!");

		bw.flush();
		bw.close();
		br.close();
	}
}
