import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		List<List<Integer>> arr = new ArrayList<List<Integer>>();
		int[] plan = new int[M];
		boolean[] visited = new boolean[N+1];
		
		for (int i = 0; i <= N; i++) {
			arr.add(new ArrayList<Integer>());
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int k = Integer.parseInt(st.nextToken());
				if (k == 1) arr.get(i).add(j);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int k = Integer.parseInt(st.nextToken());
			plan[i] = k;
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(plan[0]);
		visited[plan[0]] = true;
		while (!q.isEmpty()) {
			int tmp = q.poll();
			for (int k : arr.get(tmp)) {
				if (!visited[k]) { // 방문하지 않았을 경우
					visited[k] = true;
					q.add(k);
				}
			}
		}
		
		for (int k : plan) {
			if (!visited[k]) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
}
