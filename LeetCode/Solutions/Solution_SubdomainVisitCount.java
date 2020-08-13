import java.util.*;

public class Solution_SubdomainVisitCount {

	public static List<String> subdomainVisits(String[] cpdomains) {
		HashMap<String, Integer> hm = new HashMap<>();

		for (String domain : cpdomains) {
			String[] info = domain.split(" ");
			
			hm.put(info[1], hm.getOrDefault(info[1], 0) + Integer.parseInt(info[0]));

			int idx = info[1].indexOf(".");
			
			while (idx != -1) {
				info[1] = info[1].substring(idx + 1);
				
				hm.put(info[1], hm.getOrDefault(info[1], 0) + Integer.parseInt(info[0]));

				idx = info[1].indexOf(".");
			}
		}

		ArrayList<String> answer = new ArrayList<>();
		for (String key : hm.keySet())
			answer.add(Integer.toString(hm.get(key)) + " " + key);

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(subdomainVisits(new String[] { "9001 discuss.leetcode.com" }));
		System.out.println(subdomainVisits(
				new String[] { "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org" }));
	}

}
