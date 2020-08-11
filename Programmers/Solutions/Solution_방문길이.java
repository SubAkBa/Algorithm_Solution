import java.util.*;

public class Solution_visitlength {

	public static int solution(String dirs) {
		HashSet<Path> px = new HashSet<>();
		HashSet<Path> py = new HashSet<>();
		char[] chr = dirs.toCharArray();
		int len = chr.length, nextx = 0, nexty = 0;

		for (int i = 0; i < len; i++) {
			int herex = nextx;
			int herey = nexty;

			switch (chr[i]) {
			case 'U':
				if (nexty < 5)
					py.add(new Path(nextx, herey, (++nexty)));
				break;
			case 'D':
				if (nexty > -5)
					py.add(new Path(nextx, (--nexty), herey));
				break;
			case 'L':
				if (nextx > -5)
					px.add(new Path(nexty, (--nextx), herex));
				break;
			case 'R':
				if (nextx < 5)
					px.add(new Path(nexty, herex, (++nextx)));
				break;
			}
		}

		return px.size() + py.size();
	}

	public static class Path {
		int f, p1, p2;

		public Path(int f, int p1, int p2) {
			this.f = f;
			this.p1 = p1;
			this.p2 = p2;
		}

		public int hashCode() {
			return Objects.hash(f, p1, p2);
		}

		public boolean equals(Object obj) {
			if (obj instanceof Path) {
				Path path = (Path) obj;

				if (this.f == path.f && this.p1 == path.p1 && this.p2 == path.p2)
					return true;
			}
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(solution("ULURRDLLU"));
		System.out.println(solution("LULLLLLLU"));
	}

}
