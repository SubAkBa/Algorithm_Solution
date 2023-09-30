package org.example;

import java.io.*;
import java.util.*;

public class Solution_13023 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int result;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer>[] adjList = new ArrayList[N];
		boolean[] visited = new boolean[N];
		result = 0;

		for (int i = 0; i < N; ++i) {
			adjList[i] = new ArrayList<>();
		}

		while ((--M) >= 0) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjList[a].add(b);
			adjList[b].add(a);
		}

		for (int i = 0; i < N && result == 0; ++i) {
			DFS(adjList, visited, i, 1);

			Arrays.fill(visited, false);
		}

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		br.close();
	}

	public static void DFS(List<Integer>[] adjList, boolean[] visited, int node, int depth) {
		if (visited[node]) {
			return;
		}

		if (result == 1 || depth == 5) {
			result = 1;
			return;
		}

		visited[node] = true;

		for (int next : adjList[node]) {
			DFS(adjList, visited, next, depth + 1);
		}

		visited[node] = false;
	}
}
