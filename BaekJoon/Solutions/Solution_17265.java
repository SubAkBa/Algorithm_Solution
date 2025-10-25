import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_17265 {
	public static class Element {
		int x, y, value;
		char operator;

		public Element(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}

		public Element(int x, int y, int value, char operator) {
			this.x = x;
			this.y = y;
			this.value = value;
			this.operator = operator;
		}
	}

	public static int[] bfs(char[][] map, int N) {
		int[] dx = {0, 1}, dy = {1, 0};
		int[] results = {Integer.MAX_VALUE, Integer.MIN_VALUE};
		Queue<Element> queue = new ArrayDeque<>();

		queue.offer(new Element(0, 0, map[0][0] - '0'));

		while (!queue.isEmpty()) {
			Element current = queue.poll();

			if (current.x == N - 1 && current.y == N - 1) {
				results[0] = Math.min(results[0], current.value);
				results[1] = Math.max(results[1], current.value);
				continue;
			}

			for (int i = 0; i < 2; ++i) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];

				if (!(nx < N && ny < N)) {
					continue;
				}

				if (Character.isDigit(map[nx][ny])) {
					int value2 = map[nx][ny] - '0';
					int calc = 0;

					switch (current.operator) {
						case '*':
							calc = current.value * value2;
							break;
						case '+':
							calc = current.value + value2;
							break;
						case '-':
							calc = current.value - value2;
							break;
					}

					queue.offer(new Element(nx, ny, calc));
				} else {
					queue.offer(new Element(nx, ny, current.value, map[nx][ny]));
				}
			}
		}

		return results;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; ++j) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}

		int[] results = bfs(map, N);

		System.out.println(results[1] + " " + results[0]);
	}
}
