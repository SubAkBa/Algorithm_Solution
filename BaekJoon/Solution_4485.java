import java.util.*;
import java.io.*;

public class dijkstra_4485_solution {
	static int num, nx, ny, ncost;
	static int[][] cave;
	static int[][] dist;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, 1, -1 };
	final static int INF = 987654321;
	
	static Point from;
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;

	public static int Dijkstra(int x, int y) {
		PriorityQueue<Point> queue = new PriorityQueue<Point>();

		dist[x][y] = cave[x][y];
		queue.offer(new Point(x, y, cave[x][y]));

		while (!queue.isEmpty()) {
			from = queue.poll();

			if(dist[from.x][from.y] < from.cost)
				continue;
				
			for (int i = 0; i < 4; i++) {
				nx = dx[i] + from.x;
				ny = dy[i] + from.y;

				if (0 <= nx && nx < num && 0 <= ny && ny < num) {
					ncost = cave[nx][ny];
					
					if (dist[nx][ny] > dist[from.x][from.y] + ncost) {
						
						queue.offer(new Point(nx, ny, cave[nx][ny]));
						dist[nx][ny] = dist[from.x][from.y] + ncost;
						
					}
				}
			}
		}

		return dist[num - 1][num - 1];
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = 0, result = 0;

		while (true) {
			num = Integer.parseInt(br.readLine());

			if (num == 0)
				break;
			
			count++;

			cave = new int[num][num];
			dist = new int[num][num];

			for (int i = 0; i < num; i++) {
				st = new StringTokenizer(br.readLine());
				int j = 0;

				while(st.hasMoreTokens()) {
					cave[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = INF;
					j++;
				}
			}

			result = Dijkstra(0, 0);
			
			bw.write("Problem " + count + ": " + result);
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}

class Point implements Comparable<Point>{
	int x, y, cost;

	public Point(int x, int y, int cost) {
		this.x = x;
		this.y = y;
		this.cost = cost;
	}

	@Override
	public int compareTo(Point p1) {
		if(this.cost > p1.cost)
			return 1;
		else if(this.cost < p1.cost)
			return -1;
		else
			return 0;
	}
	
}