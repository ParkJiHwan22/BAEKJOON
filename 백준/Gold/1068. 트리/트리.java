import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] son = new int[N];
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] != -1) son[arr[i]] ++;
		}
		int D = Integer.parseInt(br.readLine());
				
		Queue<Integer> q = new LinkedList<>();
		q.add(D);
		
		boolean[] visited = new boolean[N];
		
		while (!q.isEmpty()) {
			int p = q.poll();
			son[p] = -1;
			if (arr[p] != -1) son[arr[p]]--;
			for (int i = 0; i < N; i++) {
				if (arr[i] == p && !visited[i]) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (son[i] == 0) cnt++;
		}

		System.out.println(cnt);
	}
}