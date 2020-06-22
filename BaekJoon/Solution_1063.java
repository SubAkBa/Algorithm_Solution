import java.io.*;
import java.util.*;

public class Solution_1063 {
	static HashMap<String, int[]> dpos;
	static int size = 8;
	static int[] king_pos, stone_pos;

	public static void Init() {
		dpos.put("T", new int[] { 0, 1 });
		dpos.put("B", new int[] { 0, -1 });
		dpos.put("L", new int[] { -1, 0 });
		dpos.put("R", new int[] { 1, 0 });
		dpos.put("RT", new int[] { 1, 1 });
		dpos.put("LT", new int[] { -1, 1 });
		dpos.put("RB", new int[] { 1, -1 });
		dpos.put("LB", new int[] { -1, -1 });
	}

	public static boolean isRange(int x, int y) {
		if (!(0 <= x && x < size && 0 <= y && y < size))
			return false;

		return true;
	}

	public static void Move(String order) {
		int[] d_pos = dpos.get(order);

		int nx = king_pos[0] + d_pos[0];
		int ny = king_pos[1] + d_pos[1];
		if (!isRange(nx, ny))
			return;

		if (nx == stone_pos[0] && ny == stone_pos[1]) {
			int nx1 = stone_pos[0] + d_pos[0];
			int ny1 = stone_pos[1] + d_pos[1];

			if (!isRange(nx1, ny1))
				return;

			stone_pos[0] = nx1;
			stone_pos[1] = ny1;
		}

		king_pos[0] = nx;
		king_pos[1] = ny;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String king_str = st.nextToken();
		String stone_str = st.nextToken();
		int N = Integer.parseInt(st.nextToken());

		dpos = new HashMap<>();
		king_pos = new int[] { king_str.charAt(0) - 'A', king_str.charAt(1) - '1' };
		stone_pos = new int[] { stone_str.charAt(0) - 'A', stone_str.charAt(1) - '1' };

		Init();

		for (int i = 0; i < N; i++)
			Move(br.readLine());

		bw.write((char) (king_pos[0] + 'A') + "" + (king_pos[1] + 1) + "\n");
		bw.write((char) (stone_pos[0] + 'A') + "" + (stone_pos[1] + 1));
		bw.flush();
		bw.close();
		br.close();
	}

}
