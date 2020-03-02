import java.util.*;
import java.io.*;

public class simulation_2161_solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int num = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= num; i++)
			queue.offer(i);

		while (!queue.isEmpty() && queue.peek() != null) {
			bw.write(queue.poll() + " ");

			queue.offer(queue.poll());
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
