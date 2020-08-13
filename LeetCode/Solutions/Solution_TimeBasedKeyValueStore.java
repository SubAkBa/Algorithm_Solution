import java.util.*;

public class Solution_TimeBasedKeyValueStore {

	public static class TimeMap {
		HashMap<String, TreeMap<Integer, String>> hm;

		/** Initialize your data structure here. */
		public TimeMap() {
			hm = new HashMap<>();
		}

		public void set(String key, String value, int timestamp) {
			if (!hm.containsKey(key))
				hm.put(key, new TreeMap<>());

			hm.get(key).put(timestamp, value);
		}

		public String get(String key, int timestamp) {
			if (!hm.containsKey(key))
				return "";

			TreeMap<Integer, String> tm = hm.get(key);
			Integer time = tm.floorKey(timestamp);

			return (time == null ? "" : tm.get(time));
		}
	}

	/**
	 * Your TimeMap object will be instantiated and called as such: TimeMap obj =
	 * new TimeMap(); obj.set(key,value,timestamp); String param_2 =
	 * obj.get(key,timestamp);
	 */

	public static void main(String[] args) {
		TimeMap kv = new TimeMap();
		kv.set("foo", "bar", 1);
		System.out.println(kv.get("foo", 1));
		System.out.println(kv.get("foo", 3));

		kv.set("foo", "bar2", 4);
		System.out.println(kv.get("foo", 4));
		System.out.println(kv.get("foo", 5));
	}

}
