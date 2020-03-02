import java.io.*;
import java.util.*;

public class bfs_2667_solution {
	static int dangecount = 0, count = 0;
	static PriorityQueue<Integer> output = new PriorityQueue<Integer>();
	static boolean[][] visit;
	static int[][] map;

	public static void BFS(int x, int y) {
		int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, 1, -1 };
		int nx = 0, ny = 0;
		
		visit[x][y] = true;
		map[x][y] = 0;
		count++;

		for (int i = 0; i < 4; i++) {
			nx = dx[i] + x;
			ny = dy[i] + y;

			if (0 <= nx && nx < map.length && 0 <= ny && ny < map.length) {
				
				if (map[nx][ny] == 1)
					BFS(nx, ny);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		map = new int[num][num];
		visit = new boolean[num][num];
		char[] inputmap = null;

		for (int i = 0; i < num; i++) {
			inputmap = br.readLine().toCharArray();

			for (int j = 0; j < num; j++) {
				map[i][j] = Character.getNumericValue(inputmap[j]);
				visit[i][j] = false;
			}
		}

		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				
				if (map[i][j] == 1 && !visit[i][j]) {
					count = 0;

					BFS(i, j);

					dangecount++;
					output.offer(count);
				}
			}
		}

		System.out.println(dangecount);

		while (!output.isEmpty())
			System.out.println(output.poll());
		
	}

}