import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1189 {
	static int answer = 0;
	static int R, C, K;
	static char[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void dfs(int x, int y, int count) {
		if (count == K) {
			if (x == 0 && y == C - 1) {
				++answer;
			}

			return;
		}

		for (int i = 0; i < 4; ++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (!(0 <= nx && nx < R && 0 <= ny && ny < C)) {
				continue;
			}

			if (map[nx][ny] == 'T') {
				continue;
			}

			map[nx][ny] = 'T';
			dfs(nx, ny, count + 1);
			map[nx][ny] = '.';
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int i = 0; i < R; ++i) {
			map[i] = br.readLine().toCharArray();
		}

		map[R - 1][0] = 'T';
		dfs(R - 1, 0, 1);

		System.out.println(answer);
	}
}
