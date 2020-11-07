import java.util.*;
import java.io.*;

public class Solution_6416 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int k = 0;
		
		while (true) {
			Set<Integer> table = new HashSet<>();
			int E = 0;
			int[] indeg = new int[1001];

			while (true) {
				int a = sc.nextInt();
				int b = sc.nextInt();

				if (a == -1 && b == -1)
					return;

				if (a == 0 && b == 0)
					break;

				table.add(a);
				table.add(b);
				++indeg[b];
				++E;
			}

			if (table.size() == 0) {
				System.out.println("Case " + (++k) + " is a tree.");
				continue;
			}

			Iterator<Integer> iter = table.iterator();
			boolean chk_root = false, isTree = true;
			while (iter.hasNext()) {
				int value = indeg[iter.next()];

				if (value == 0) {
					if (chk_root) {
						isTree = false;
						break;
					}

					chk_root = true;
				} else if (value > 1) {
					isTree = false;
					break;
				}
			}

			if (!isTree || (table.size() - E) != 1)
				System.out.println("Case " + (++k) + " is not a tree.");
			else
				System.out.println("Case " + (++k) + " is a tree.");
		}
	}
}
