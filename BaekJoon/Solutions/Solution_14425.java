import java.util.*;
import java.io.*;

public class Solution_14425 {
	// static int size = 26;
	//
	// public static class Node {
	// 	boolean isTerminal;
	// 	Node[] nodes;
	//
	// 	public Node() {
	// 		this.isTerminal = false;
	// 		nodes = new Node[size];
	// 	}
	// }
	//
	// public static class Trie {
	// 	Node root;
	//
	// 	public Trie() {
	// 		this.root = new Node();
	// 	}
	//
	// 	public void insert(String str) {
	// 		Node current = root;
	//
	// 		for (int i = 0; i < str.length(); ++i) {
	// 			int idx = str.charAt(i) - 'a';
	//
	// 			if (current.nodes[idx] == null) {
	// 				current.nodes[idx] = new Node();
	// 			}
	//
	// 			current = current.nodes[idx];
	// 		}
	//
	// 		current.isTerminal = true;
	// 	}
	//
	// 	public boolean existString(String str) {
	// 		Node current = root;
	//
	// 		for (int i = 0; i < str.length(); ++i) {
	// 			int idx = str.charAt(i) - 'a';
	//
	// 			if (current.nodes[idx] == null) {
	// 				return false;
	// 			}
	//
	// 			current = current.nodes[idx];
	// 		}
	//
	// 		return current != null && current.isTerminal;
	// 	}
	// }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int count = 0;
		// Trie trie = new Trie();
		//
		// for (int i = 0; i < N; ++i) {
		// 	trie.insert(br.readLine());
		// }
		//
		// for (int i = 0; i < M; ++i) {
		// 	if (trie.existString(br.readLine())) {
		// 		++count;
		// 	}
		// }

		Set<String> cache = new HashSet<>();

		for (int i = 0; i < N; ++i)
			cache.add(br.readLine());

		for (int i = 0; i < M; ++i) {
			if (cache.contains(br.readLine()))
				++count;
		}

		bw.write(count + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
