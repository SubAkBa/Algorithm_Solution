import java.util.*;
import java.io.*;

public class trie_5670_solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str;
		while((str = br.readLine()) != null) {
			int kcount = Integer.parseInt(str), time = 0;

			Trie t = new Trie();

			String[] words = new String[kcount];
			for (int i = 0; i < kcount; i++) {
				words[i] = br.readLine();

				t.Insert(words[i]);
			}

			for (int i = 0; i < kcount; i++)
				time += t.GetInputTime(words[i]);

			bw.write(String.format("%.2f", (double) time / kcount) + "\n");
			bw.flush();
		}

		bw.close();
		br.close();
	}

}

class TrieNode {
	static final int ALPHABET_SIZE = 26;
	boolean isEndofWord;
	TrieNode[] children = new TrieNode[ALPHABET_SIZE];

	public TrieNode() {
		this.isEndofWord = false;
		for (int i = 0; i < ALPHABET_SIZE; i++)
			this.children[i] = null;
	}

	public boolean isMoreTwoChildren() {
		int count = 0;

		for (int i = 0; i < ALPHABET_SIZE; i++) {
			if (children[i] != null)
				count++;

			if (count == 2)
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

	public void Insert(String word) {
		TrieNode temp = root;

		for (int i = 0; i < word.length(); i++) {
			int idx = word.charAt(i) - 'a';

			if (temp.children[idx] == null)
				temp.children[idx] = new TrieNode();

			temp = temp.children[idx];
		}

		temp.isEndofWord = true;
	}

	public int GetInputTime(String word) {
		int time = 1;

		TrieNode temp = root.children[word.charAt(0) - 'a'];

		for (int level = 1; level < word.length(); level++) {
			int idx = word.charAt(level) - 'a';

			if (temp.isEndofWord || temp.isMoreTwoChildren())
				time++;
			
			temp = temp.children[idx];
		}

		return time;
	}
}