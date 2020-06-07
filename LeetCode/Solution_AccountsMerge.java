import java.util.*;

public class Solution_AccountsMerge {
	static int[] parent, rank;
	static int MAX = 10001;

	public static void Init() {
		parent = new int[MAX];
		rank = new int[MAX];

		for (int i = 0; i < MAX; i++)
			parent[i] = i;
	}

	public static int Find(int u) {
		if (parent[u] == u)
			return u;

		return parent[u] = Find(parent[u]);
	}

	public static void Union(int u, int v) {
		int uR = Find(u);
		int vR = Find(v);

		if (uR == vR)
			return;

		if (rank[uR] > rank[vR]) {
			int temp = uR;
			uR = vR;
			vR = temp;
		}

		parent[uR] = vR;

		if (rank[uR] == rank[vR])
			rank[vR]++;
	}

	public static List<List<String>> accountsMerge(List<List<String>> accounts) {
		HashMap<String, String> mailtoname = new HashMap<String, String>();
		HashMap<String, Integer> mailtoid = new HashMap<String, Integer>();
		int id = 0;

		Init();

		for (List<String> account : accounts) {

			String name = account.get(0);
			int asize = account.size();

			for (int i = 1; i < asize; i++) {
				String mail = account.get(i);

				mailtoname.put(mail, name);

				if (!mailtoid.containsKey(mail))
					mailtoid.put(mail, id++);

				Union(mailtoid.get(account.get(1)), mailtoid.get(mail));
			}
		}

		HashMap<Integer, List<String>> maillist = new HashMap<>();

		for (String mail : mailtoid.keySet()) {
			int idx = Find(mailtoid.get(mail));
			maillist.computeIfAbsent(idx, x -> new ArrayList<>()).add(mail);
		}

		for (List<String> mails : maillist.values()) {
			Collections.sort(mails);
			mails.add(0, mailtoname.get(mails.get(0)));
		}

		return new ArrayList<>(maillist.values());
	}

	public static void main(String[] args) {
		List<List<String>> accounts = new ArrayList<List<String>>();

		String[][] str = { { "Alex", "Alex5@m.co", "Alex4@m.co", "Alex0@m.co" },
				{ "Ethan", "Ethan3@m.co", "Ethan3@m.co", "Ethan0@m.co" },
				{ "Kevin", "Kevin4@m.co", "Kevin2@m.co", "Kevin2@m.co" },
				{ "Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe2@m.co" },
				{ "Gabe", "Gabe3@m.co", "Gabe4@m.co", "Gabe2@m.co" } };

		for (int i = 0; i < str.length; i++) {
			accounts.add(new ArrayList<>());
			
			for (int j = 0; j < str[i].length; j++)
				accounts.get(i).add(str[i][j]);
		}

		System.out.println(accountsMerge(accounts));
	}

}
