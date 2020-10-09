import java.util.*;

public class Solution_LRUCache {
	class LRUCache {
		Map<Integer, Node> cache;
		int capacity;
		Node head, tail;

		public LRUCache(int capacity) {
			cache = new HashMap<>();
			head = new Node(0, 0);
			tail = new Node(0, 0);

			head.next = tail;
			tail.prev = head;

			this.capacity = capacity;
		}

		public int get(int key) {
			Node node = cache.get(key);

			if (node == null)
				return -1;

			int value = node.value;

			Delete(node);
			AddToHead(node);

			return value;
		}

		public void put(int key, int value) {
			Node node = cache.get(key);

			if (node != null) {
				node.value = value;
				Delete(node);
				AddToHead(node);
			} else {
				Node newNode = new Node(key, value);

				if (isFull()) {
					cache.remove(tail.prev.key);
					Delete(tail.prev);
					AddToHead(newNode);
				} else {
					--capacity;
					AddToHead(newNode);
				}
				
				cache.put(key, newNode);
			}
		}

		public boolean isFull() {
			return capacity == 0;
		}

		public void AddToHead(Node node) {
			node.next = head.next;
			node = node.next.prev;

			head.next = node;
			node.prev = head;
		}

		public void Delete(Node node) {
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}
	}

	public class Node {
		Node prev, next;
		int key, value;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
}
