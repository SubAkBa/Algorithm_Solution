package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_11724 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer>[] adjList = new ArrayList[N + 1];
		boolean[] visited = new boolean[N + 1];

		for (int i = 1; i <= N; ++i) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			adjList[u].add(v);
			adjList[v].add(u);
		}

		int result = 0;
		for (int i = 1; i <= N; ++i) {
			if (visited[i]) {
				continue;
			}

			DFS(adjList, visited, i);
			++result;
		}

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		br.close();
	}

	public static void DFS(List<Integer>[] adjList, boolean[] visited, int node) {
		if (visited[node]) {
			return;
		}

		visited[node] = true;

		for (int next : adjList[node]) {
			DFS(adjList, visited, next);
		}
	}
}
