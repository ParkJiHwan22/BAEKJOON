import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		int[][] map = new int[N][M];
		int[][][] graph = new int[N][M][K + 1];
		int ans = -1;
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {0, 0, 0, 0});	// y좌표, x좌표, 이동한 위치 수, 벽 뚫은 개수
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			if (tmp[0] == N - 1 && tmp[1] == M - 1) {
				ans = tmp[2] + 1;
				break;
			}
			
			for (int dir = 0; dir < 4; dir++) {
				int ny = tmp[0] + dy[dir];
				int nx = tmp[1] + dx[dir];
				
				if (ny < N && ny >= 0 && nx < M && nx >= 0) {
					if (map[ny][nx] == 1 && tmp[3] < K && (graph[ny][nx][tmp[3] + 1] == 0 || tmp[2] + 1 < graph[ny][nx][tmp[3] + 1])) {
						graph[ny][nx][tmp[3] + 1] = tmp[2] + 1;
						q.add(new int[] {ny, nx, tmp[2] + 1, tmp[3] + 1});
					} else if (map[ny][nx] == 0 && (graph[ny][nx][tmp[3]] == 0 || tmp[2] + 1 < graph[ny][nx][tmp[3]])) {
						graph[ny][nx][tmp[3]] = tmp[2] + 1;
						q.add(new int[] {ny, nx, tmp[2] + 1, tmp[3]});
					}
				}
			}
		}
		System.out.println(ans);
	}
}
