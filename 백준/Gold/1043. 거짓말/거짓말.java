import java.io.*;
import java.util.*;

public class Main {
	
	private static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parent = new int[N];
		int answer = 0;
		
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		int knowCnt = Integer.parseInt(st.nextToken());
		int p = -1;	// 진실의 루트 노드
		
		if (knowCnt > 0) {
			p = Integer.parseInt(st.nextToken()) - 1;
			
			for (int i = 1; i < knowCnt; i++) {
				int k = Integer.parseInt(st.nextToken()) - 1;
				parent[k] = p;
			}	
		}
		
		List<ArrayList<Integer>> arrs = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < M; i++) {
			arrs.add(new ArrayList<Integer>());
		}		
		
		// arrs에 값 넣기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < cnt; j++) {
				int num = Integer.parseInt(st.nextToken());
				arrs.get(i).add(num - 1);
			}	
		}
				
		boolean[] visited = new boolean[M];
		boolean isMoved = true;
		
		// 한바퀴 돌 때, 새로운 모임이 추가되지 않는 경우에는 stop
		while (true) {
			isMoved = false;
			
			for (int i = 0; i < M; i++) {
				boolean isTrue = false;
				
				if (!visited[i]) {
					for (int a : arrs.get(i)) {
						if (parent[a] == p) {
							for (int b : arrs.get(i)) {
								parent[b] = p;
							}
							visited[i] = true;
							isMoved = true;
						}
					}
				}
			}
			if (!isMoved) break;
		}
		
		for (boolean v : visited) {
			if (!v) answer++;
		}
		
		System.out.println(answer);
	}
}