import java.util.*;

public class Solution_phonenumberlist {
	public static boolean solution(String[] phone_book) {
		boolean answer = true;
		int len = phone_book.length;
		Trie trie = new Trie();

		for (int i = 0; i < len; i++)
			trie.Insert(phone_book[i]);

		for (int i = 0; i < len; i++) {
			if (trie.isPrefix(phone_book[i])) {
				answer = false;
				break;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new String[] { "119", "97674223", "1195524421" }));
		System.out.println(solution(new String[] { "123", "456", "789" }));
		System.out.println(solution(new String[] { "12", "123", "1235", "567", "88" }));
	}

}

class TrieNode {
	static int NUMBER_SIZE = 10;
	boolean isEndofNumber;

	TrieNode[] children = new TrieNode[NUMBER_SIZE];

	public TrieNode() {
		this.isEndofNumber = false;

		for (int i = 0; i < NUMBER_SIZE; i++)
			children[i] = null;
	}

	public boolean isExistedChildren() {
		for (int i = 0; i < 10; i++) {
			if (children[i] != null)
				return true;
		}

		return false;
	}
}

class Trie {
	TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void Insert(String key) {
		TrieNode temp = this.root;

		for (int i = 0; i < key.length(); i++) {
			int idx = key.charAt(i) - '0';

			if (temp.children[idx] == null)
				temp.children[idx] = new TrieNode();

			temp = temp.children[idx];
		}

		temp.isEndofNumber = true;
	}

	public boolean isPrefix(String key) {
		TrieNode temp = this.root;

		for (int i = 0; i < key.length(); i++) {
			int idx = key.charAt(i) - '0';

			if (temp.isEndofNumber && temp.isExistedChildren())
				return true;

			temp = temp.children[idx];
		}

		return false;
	}
}