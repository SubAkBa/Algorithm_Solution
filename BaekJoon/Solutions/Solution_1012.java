import java.util.*;
import java.io.*;

public class bfs_1012_solution {

	public static void BFS(int[][] map, int x, int y) {
		int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, 1, -1 };
		int nx, ny;

		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			
			if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length)
				continue;
			
			if(map[nx][ny] == 0)
				continue;
			
			map[nx][ny] = 0;
			BFS(map, nx, ny);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int testcase = Integer.parseInt(br.readLine());
		String[] info, exist;
		int row, col, count;
		int[][] map;

		for (int i = 0; i < testcase; i++) {
			info = br.readLine().split(" ");

			row = Integer.parseInt(info[1]);
			col = Integer.parseInt(info[0]);
			count = 0;

			map = new int[row][col];
			for (int j = 0; j < Integer.parseInt(info[2]); j++) {
				exist = br.readLine().split(" ");
				map[Integer.parseInt(exist[1])][Integer.parseInt(exist[0])] = 1;
			}

			for (int x = 0; x < row; x++) {
				for (int y = 0; y < col; y++) {
					if (map[x][y] != 0) {
						BFS(map, x, y);
						count++;
					}
				}
			}

			sb.append(count + "\n");
		}

		System.out.println(sb.toString());
	}

}
