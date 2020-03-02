import java.util.*;

public class Solution_cache {

	public static int solution(int cacheSize, String[] cities) {
		int time = 0;
		LinkedList<String> list = new LinkedList<>();

		if (cacheSize == 0)
			return 5 * cities.length;

		for (int i = 0; i < cities.length; i++) {
			time += 5;

			if (list.contains(cities[i].toLowerCase())) {
				time -= 4;
				list.remove(cities[i].toLowerCase());
				list.add(cities[i].toLowerCase());
			} else {
				list.add(cities[i].toLowerCase());

				if (list.size() > cacheSize)
					list.removeFirst();

			}
		}

		return time;
	}

	public static void main(String[] args) {
		System.out.println(solution(3, 
				new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
		System.out.println(solution(3, 
				new String[] {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
		System.out.println(solution(2, 
				new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
		System.out.println(solution(5, 
				new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
		System.out.println(solution(2, 
				new String[] {"Jeju", "Pangyo", "NewYork", "newyork"}));
		System.out.println(solution(0, 
				new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
	}

}
