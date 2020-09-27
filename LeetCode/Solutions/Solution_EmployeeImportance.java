import java.util.*;

public class Solution_EmployeeImportance {

//	public int DFS(Map<Integer, Employee> table, int id) {
//		int total = table.get(id).importance;
//
//		for (int sub_id : table.get(id).subordinates)
//			total += DFS(table, sub_id);
//
//		return total;
//	}

	public int BFS(Map<Integer, Employee> table, int id) {
		Queue<Employee> queue = new LinkedList<>();
		int total = 0;

		queue.offer(table.get(id));

		while (!queue.isEmpty()) {
			Employee e = queue.poll();

			total += e.importance;

			for (int sub_id : e.subordinates)
				queue.offer(table.get(sub_id));
		}

		return total;
	}

	public int getImportance(List<Employee> employees, int id) {
		Map<Integer, Employee> table = new HashMap<>();

		for (Employee e : employees)
			table.put(e.id, e);

//		return DFS(table, id);
		return BFS(table, id);
	}

	public class Employee {
		public int id;
		public int importance;
		public List<Integer> subordinates;
	};
}
