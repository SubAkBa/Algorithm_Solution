import java.util.*;
import java.io.*;

public class bfs_10026_solution {
	static char[][] map;
	static char[][] cpmap;
	static boolean[][] visit;
	static boolean[][] cpvisit;
	static int num;

	public static void BFS(char ch, int x, int y, int flag) {
		int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
		int nx, ny;

		if (flag == 0) {
			visit[x][y] = true;

			for (int i = 0; i < 4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];

				if (0 <= nx && nx < num && 0 <= ny && ny < num) {
					if (!visit[nx][ny] && map[nx][ny] == ch) {
						BFS(ch, nx, ny, flag);
					}
				}
			}
		} else {
			cpvisit[x][y] = true;

			for (int i = 0; i < 4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];

				if (0 <= nx && nx < num && 0 <= ny && ny < num) {
					if (!cpvisit[nx][ny] && cpmap[nx][ny] == ch) {
						BFS(ch, nx, ny, flag);
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int count = 0, cpcount = 0;

		num = Integer.parseInt(br.readLine());

		map = new char[num][num];
		cpmap = new char[num][num];

		visit = new boolean[num][num];
		cpvisit = new boolean[num][num];

		for (int i = 0; i < num; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < num; j++) {
				visit[i][j] = false;
				cpvisit[i][j] = false;

				if (map[i][j] == 'G')
					cpmap[i][j] = 'R';
				else
					cpmap[i][j] = map[i][j];
			}
		}

		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if (!visit[i][j]) {
					BFS(map[i][j], i, j, 0);
					count++;
				}

				if (!cpvisit[i][j]) {
					BFS(cpmap[i][j], i, j, 1);
					cpcount++;
				}
			}
		}

		System.out.println(count + " " + cpcount);
	}

}
