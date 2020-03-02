import java.util.*;
import java.io.*;

public class bfs_1697_solution {

	public static int FindBrother(int cursubin, int brother, int[] visit) {
		int[] nextsubin = new int[3];

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(cursubin);
		visit[cursubin] = 0;

		while (!queue.isEmpty() && cursubin != brother) {
			cursubin = queue.poll();

			nextsubin[0] = cursubin - 1;
			nextsubin[1] = cursubin + 1;
			nextsubin[2] = cursubin * 2;

			for (int i = 0; i < 3; i++) {
				if (0 <= nextsubin[i] && nextsubin[i] <= 100000) {
					if (visit[nextsubin[i]] == -1) {
						queue.offer(nextsubin[i]);
						visit[nextsubin[i]] = visit[cursubin] + 1;
					}
				}
			}

		}
		
		return visit[brother];

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] posinfo = br.readLine().split(" ");
		int[] visit = new int[100001];
		
		int subin = Integer.parseInt(posinfo[0]);
		int brother = Integer.parseInt(posinfo[1]);

		Arrays.fill(visit, -1);

		System.out.println(FindBrother(subin, brother, visit));
	}

}
