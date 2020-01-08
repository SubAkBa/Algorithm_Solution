import java.util.*;
import java.io.*;

public class Solution_1717 {
	static int[] parent, rank;
	static int n;
	
	public static void Swap(int n1, int n2) {
		int temp = n1;
		n1 = n2;
		n2 = temp;
	}
	
	// 현재 원소가 속한 집합의 루트 노드 번호를 출력
	public static int Find(int u) {
		if(u == parent[u]) // 동일하다면 u는 루트노드이므로 그대로 반
			return u;
		
		return parent[u] = Find(parent[u]); // 경로 압축 최적화
	}
	
	// u, v가 속한 집합을 합쳐주는 연
	public static void Union(int u, int v) {
		int uR = Find(u); 		 // u가 속한 집합의 루트 노드를 찾아준다.
		int vR = Find(v); 		 // v가 속한 집합의 루트 노드를 찾아준다.
		
		if(rank[uR] > rank[vR])  // 일관성을 주기 위해 vR 쪽을 항상 크게 해준다.
			Swap(uR, vR);
		
		parent[uR] = vR;		 // 크기가 큰 집합에 작은 집합을 넣어준다.
		
		if(rank[uR] == rank[vR]) // 두 집합의 크기가 동일하다면
			rank[vR]++;			 // 한 쪽 집합 크기를 1 증가시켜준다.
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parent = new int[n + 1];
		rank = new int[n + 1];

		for (int i = 1; i <= n; i++)
			parent[i] = i;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int type = Integer.parseInt(st.nextToken());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			switch(type) {
			case 0:
				Union(n1, n2);
				break;
			case 1:
				if(Find(n1) == Find(n2))
					bw.write("YES\n");
				else
					bw.write("NO\n");
				break;
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
