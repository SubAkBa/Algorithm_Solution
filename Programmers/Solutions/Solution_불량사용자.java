import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution_baduser {
	static HashSet<String> hs;
	static int ulen, blen;

	public static void MatchingID(String[] user_id, String[] banned_id, LinkedList<String> namelist, boolean[] selected,
			int idx) {
		
		if (blen == namelist.size()) {
			LinkedList<String> temp = new LinkedList<>();
			
			temp.addAll(namelist);
			Collections.sort(temp);

			StringBuilder sb = new StringBuilder();
			for (String name : temp)
				sb.append(name);
			
			hs.add(sb.toString());

			return;
		}

		if(idx == blen)
			return;

		int bidlen = banned_id[idx].length();

		for (int i = 0; i < ulen; i++) {
			if (selected[i])
				continue;

			int uidlen = user_id[i].length();

			if (uidlen != bidlen)
				continue;

			int k = 0;
			for (; k < bidlen; k++) {
				if (user_id[i].charAt(k) != banned_id[idx].charAt(k) && banned_id[idx].charAt(k) != '*')
					break;
			}

			if (k == bidlen) {
				selected[i] = true;
				namelist.add(user_id[i]);

				MatchingID(user_id, banned_id, namelist, selected, idx + 1);

				selected[i] = false;
				namelist.removeLast();
			}
		}
	}

	public static int solution(String[] user_id, String[] banned_id) {
		hs = new HashSet<>();
		ulen = user_id.length;
		blen = banned_id.length;
		boolean[] selected = new boolean[ulen];

		MatchingID(user_id, banned_id, new LinkedList<>(), selected, 0);

		return hs.size();
	}

	public static void main(String[] args) {
		System.out.println(solution(new String[] { "frodo", "fradi", "crodo", "abc123", "frodoc" },
				new String[] { "fr*d*", "abc1**" }));
		System.out.println(solution(new String[] { "frodo", "fradi", "crodo", "abc123", "frodoc" },
				new String[] { "*rodo", "*rodo", "******" }));
		System.out.println(solution(new String[] { "frodo", "fradi", "crodo", "abc123", "frodoc" },
				new String[] { "fr*d*", "*rodo", "******", "******" }));
	}

}
