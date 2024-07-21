import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] dy = {0, 1, 0, -1};
		int[] dx = {1, 0, -1, 0};
		int res = 0;
		
		// 1. 배열에 정보 활용 가능하도록 입력 받음
		int[][] matrix = new int[N][M];
		int[][] visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], Integer.MAX_VALUE);	
		}
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				matrix[i][j] = str.charAt(j) - '0';
			}
		}
		
		// 2. 시작점을 queue에 넣음
		visited[0][0] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[0], b[0]));
		pq.add(new int[] {0, 0, 0}); // 뚫은 벽 개수,y좌표, x좌표
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			for (int dir = 0; dir < 4; dir++) {
				int ny = cur[1] + dy[dir];
				int nx = cur[2] + dx[dir];
			
				if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[cur[1]][cur[2]] + matrix[ny][nx] >= visited[ny][nx]) continue;
				
				visited[ny][nx] = visited[cur[1]][cur[2]] + matrix[ny][nx];
				pq.add(new int[] {visited[ny][nx], ny, nx});
			}
		}
		
		System.out.println(visited[N-1][M-1]);
	}
}
