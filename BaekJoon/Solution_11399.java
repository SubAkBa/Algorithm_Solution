import java.util.*;
import java.io.*;

public class Solution_11399 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		PriorityQueue<Person> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++)
			pq.offer(new Person(i, Integer.parseInt(st.nextToken())));

		int result = 0;

		while (!pq.isEmpty()) {
			Person temp = pq.poll();
			
			result += (N--) * temp.time; // 핵심 솔루션 코드
		}
		
		bw.write(result + " ");
		bw.flush();
		bw.close();
		br.close();
	}

	public static class Person implements Comparable<Person> {
		int idx, time;

		public Person(int idx, int time) {
			this.idx = idx;
			this.time = time;
		}

		@Override
		public int compareTo(Person p) {
			if (this.time < p.time)
				return -1;
			else if (this.time == p.time) {
				if (this.idx < p.idx)
					return -1;
			}
			return 1;
		}
	}
}
