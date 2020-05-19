import java.util.*;
import java.io.*;

public class Solution_14891 {
	static LinkedList<Integer>[] gear;

	public static void LeftRotate(int gearidx, int w) {
		if (gearidx == 0)
			return;

		int[] tw = new int[5];
		tw[gearidx] = w;

		for (int i = gearidx - 1; i >= 1; i--) {
			if (gear[i].get(2) == gear[i + 1].get(6))
				tw[i] = 0;
			else
				tw[i] = tw[i + 1] * -1;
		}

		for (int i = gearidx - 1; i >= 1; i--) {
			if (tw[i] == 1)
				gear[i].addFirst(gear[i].removeLast());
			else if (tw[i] == -1)
				gear[i].addLast(gear[i].removeFirst());
		}
	}

	public static void RightRotate(int gearidx, int w) {
		if (gearidx == 4)
			return;

		int[] tw = new int[5];
		tw[gearidx] = w;

		for (int i = gearidx + 1; i < 5; i++) {
			if (gear[i - 1].get(2) == gear[i].get(6))
				tw[i] = 0;
			else
				tw[i] = tw[i - 1] * -1;
		}

		for (int i = gearidx + 1; i < 5; i++) {
			if (tw[i] == 1)
				gear[i].addFirst(gear[i].removeLast());
			else if (tw[i] == -1)
				gear[i].addLast(gear[i].removeFirst());
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		gear = new LinkedList[5];

		for (int i = 1; i < 5; i++) {
			char[] ch = br.readLine().toCharArray();
			gear[i] = new LinkedList<>();

			for (int j = 0; j < 8; j++)
				gear[i].add(ch[j] - '0');
		}

		int K = Integer.parseInt(br.readLine());

		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int gearidx = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			LeftRotate(gearidx, w);
			RightRotate(gearidx, w);

			if (w == 1)
				gear[gearidx].addFirst(gear[gearidx].removeLast());
			else if (w == -1)
				gear[gearidx].addLast(gear[gearidx].removeFirst());
		}

		int score = 0, power = 1;
		for (int i = 1; i < 5; i++) {
			score += gear[i].get(0) == 0 ? 0 : power;
			power *= 2;
		}

		bw.write(score + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
