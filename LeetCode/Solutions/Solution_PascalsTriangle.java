import java.util.ArrayList;
import java.util.List;

public class Solution_PascalsTriangle {
	public static List<List<Integer>> generate(int numRows) {
		List<Integer> firstList = List.of(1);
		if (numRows == 1) {
			return List.of(firstList);
		}

		List<Integer> secondList = List.of(1, 1);
		if (numRows == 2) {
			return List.of(firstList, secondList);
		}


		List<List<Integer>> pascalList = new ArrayList<>();
		pascalList.add(firstList);
		pascalList.add(secondList);

		for (int i = 1; i < numRows - 1; ++i) {
			List<Integer> list = new ArrayList<>();
			list.add(1);

			List<Integer> prevList = pascalList.get(i);
			for (int j = 1; j < prevList.size(); ++j) {
				list.add(prevList.get(j - 1) + prevList.get(j));
			}

			list.add(1);
			pascalList.add(list);
		}

		return pascalList;
	}

	public static void main(String[] args) {
		System.out.println(generate(5)); // [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
		System.out.println(generate(1)); // [[1]]
		System.out.println(generate(2)); // [[1],[1,1]]
	}
}
