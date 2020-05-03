import java.util.*;
import java.io.*;

public class Solution_hyukjinsprogramverification {
	static char[][] command;
	static int R, C;
	static boolean[][][][] visited;

	public static boolean BFS(int x, int y, int direct, int num) {
		Queue<Point> queue = new LinkedList<>();
		int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

		visited[x][y][direct][num] = true;
		queue.offer(new Point(x, y, direct, num));

		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			int nd = cur.direct, nn = cur.num;
			
			switch(command[cur.x][cur.y]) {
			case '>': nd = 0; break;
			case 'v': nd = 1; break;
			case '<': nd = 2; break;
			case '^': nd = 3; break;
			case '+': nn = (nn == 15) ? 0 : nn + 1; break;
			case '-': nn = (nn == 0) ? 15 : nn - 1; break;
			case '_': nd = (nn == 0) ? 0 : 2; break;
			case '|': nd = (nn == 0) ? 1 : 3; break;
			case '@': return true;
			case '.': break;
			case '?':
				for(int i = 0; i < 4; i++) {
					int nx = cur.x + dx[i];
					int ny = cur.y + dy[i];
					
					if(nx == -1) nx = R - 1;
					else if (nx == R) nx = 0;
					
					if(ny == -1) ny = C - 1;
					else if (ny == C) ny = 0;
					
					if(!visited[nx][ny][i][nn]) {
						queue.offer(new Point(nx, ny, i, nn));
						visited[nx][ny][i][nn] = true;
					}
				}
				break;
			default: nn = command[cur.x][cur.y] - '0'; 
			}
			
			int nx = cur.x + dx[nd];
			int ny = cur.y + dy[nd];
			
			if(nx == -1) nx = R - 1;
			else if (nx == R) nx = 0;
			
			if(ny == -1) ny = C - 1;
			else if (ny == C) ny = 0;
			
			if(!visited[nx][ny][nd][nn]) {
				queue.offer(new Point(nx, ny, nd, nn));
				visited[nx][ny][nd][nn] = true;
			}
		}
		
		return false;
	}

	public static class Point {
		int x, y, direct, num;

		public Point(int x, int y, int direct, int num) {
			this.x = x;
			this.y = y;
			this.direct = direct;
			this.num = num;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine()), count = 0;

		while ((count++) < T) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			visited = new boolean[R][C][4][16];

			command = new char[R][C];
			
			for (int i = 0; i < R; i++)
				command[i] = br.readLine().toCharArray();

			bw.write("#" + count + " " + (BFS(0, 0, 0, 0) ? "YES\n" : "NO\n"));
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
