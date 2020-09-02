import java.util.*;
import java.io.*;

public class trie_5052_solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testcase = Integer.parseInt(br.readLine());
		for (int i = 0; i < testcase; i++) {
			Trie t = new Trie();
			boolean flag = false;
			int pcount = Integer.parseInt(br.readLine());

			String[] pnumber = new String[pcount];
			for (int j = 0; j < pcount; j++) {
				pnumber[j] = br.readLine();
				t.Insert(pnumber[j]);
			}

			for (int j = 0; j < pcount; j++) {
				if (t.CheckConsistency(pnumber[j])) {
					bw.write("NO\n");
					flag = true;
					break;
				}
			}
			
			if(!flag)
				bw.write("YES\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}

class TrieNode {
	static final int NUMBER_SIZE = 10;
	boolean isEndofWord;
	TrieNode[] children = new TrieNode[NUMBER_SIZE];

	public TrieNode() {
		this.isEndofWord = false;

		for (int i = 0; i < NUMBER_SIZE; i++)
			this.children[i] = null;
	}

	public boolean isExistChildren() {
		for (int i = 0; i < NUMBER_SIZE; i++) {
			if (this.children[i] != null)
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
		TrieNode temp = root;

		for (int level = 0; level < key.length(); level++) {
			int idx = key.charAt(level) - '0';

			if (temp.children[idx] == null)
				temp.children[idx] = new TrieNode();

			temp = temp.children[idx];
		}

		temp.isEndofWord = true;
	}

	public boolean CheckConsistency(String key) {
		TrieNode temp = root;

		for (int level = 0; level < key.length(); level++) {
			int idx = key.charAt(level) - '0';

			temp = temp.children[idx];
		}

		if (temp.isExistChildren() && temp.isEndofWord)
			return true;
		else
			return false;
	}
}