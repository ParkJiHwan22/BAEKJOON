import java.io.*;
import java.util.*;

public class Main {
	
    private static int distance[][];
    private static boolean visited[];
    private static int [][] node;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		node = new int[N+1][N+1]; // 연결 여부
		distance = new int[N+1][N+1]; // 거리
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			node[a][b] = 1;
			node[b][a] = 1;
			distance[a][b] = dis;
			distance[b][a] = dis;
		}
		
        for(int i=0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b=  Integer.parseInt(st.nextToken());
            bfs(a, b, N);
        }
	}

	public static void bfs(int start, int end, int N) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visited = new boolean[N+1];
		
		visited[start] = true;
		queue.add(start);
		int ans[] = new int[N+1];
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (int i = 1; i <= N; i++) {
				if(node[cur][i] == 1 && !visited[i]) {
					ans[i] += distance[cur][i] + ans[cur];
					
					if (i == end) {
						System.out.println(ans[end]);
						return;
					}
					
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}
}
