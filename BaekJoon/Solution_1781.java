import java.util.*;
import java.io.*;

public class Solution_1781 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		int day = 0;
		int cup_ramen = 0;
		int[][] homework = new int[N][2];
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			homework[i][0] = Integer.parseInt(st.nextToken());
			homework[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(homework, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

		for (int i = 0; i < N; i++) {
			if (day < homework[i][0]) {
				day++;
				cup_ramen += homework[i][1];
				pq.offer(homework[i]);
			} else if (!pq.isEmpty() && pq.peek()[1] < homework[i][1]) {
				cup_ramen += homework[i][1] - pq.poll()[1];
				pq.offer(homework[i]);
			}
		}

		bw.write(cup_ramen + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
