import java.util.*;
import java.io.*;

public class Solution_1525 {

	public static String Swap(String state, int x, int y) {
		StringBuilder sb = new StringBuilder(state);

		char c = sb.charAt(x);
		sb.setCharAt(x, sb.charAt(y));
		sb.setCharAt(y, c);

		return sb.toString();
	}

	public static int BFS(char[] map, String start) {
		Set<String> cache = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		int[][] edge = new int[][] { { 1, 3 }, { 0, 2, 4 }, { 1, 5 }, { 0, 4, 6 }, { 1, 3, 5, 7 }, { 2, 4, 8 },
				{ 3, 7 }, { 4, 6, 8 }, { 5, 7 } };
		String answer = "123456780";

		int time = 0;

		queue.offer(start);
		cache.add(start);

		while (!queue.isEmpty()) {
			int round = queue.size();

//			System.out.println("\nround : " + round);

			while ((--round) >= 0) {
				String from_state = queue.poll();

//				for (int j = 0; j < 3; ++j)
//					System.out.println(from_state.substring(j * 3, j * 3 + 3));
//				System.out.println(answer + " " + from_state);
//				System.out.println("time : " + time + "\n");

				if (answer.equals(from_state))
					return time;

				int from = from_state.indexOf("0");

				for (int to : edge[from]) {
					String state = Swap(from_state, from, to);

					if (cache.contains(state))
						continue;

					queue.offer(state);
					cache.add(state);
				}
			}

			++time;
		}

		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = 3;

		char[] map = new char[N * N];
		int idx = -1;
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; ++j)
				map[++idx] = st.nextToken().charAt(0);
		}

		bw.write(BFS(map, String.valueOf(map)) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
