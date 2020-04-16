import java.util.*;
import java.io.*;

public class Solution_1931 {
	static PriorityQueue<Meeting> pq = new PriorityQueue<>();

	public static int MeetingRoom() {
		int count = 1;

		Meeting prev = pq.poll();

		while (!pq.isEmpty()) {
			Meeting next = pq.poll();

			if (prev.end <= next.start) {
				prev = next;
				count++;
			}
		}

		return count;
	}

	public static class Meeting implements Comparable<Meeting> {
		int start, end;

		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public int compareTo(Meeting m) {
			if (this.end == m.end) {
				return this.start - m.start;
			} else
				return this.end - m.end;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			pq.offer(new Meeting(start, end));
		}

		bw.write(MeetingRoom() + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
