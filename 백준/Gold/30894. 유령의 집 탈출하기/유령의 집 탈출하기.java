import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] graph = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		int sx = Integer.parseInt(st.nextToken()) - 1;
		int sy = Integer.parseInt(st.nextToken()) - 1;
		int ex = Integer.parseInt(st.nextToken()) - 1;
		int ey = Integer.parseInt(st.nextToken()) - 1;
				
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = str.charAt(j);
                if (c == '.') graph[i][j] = 0;    // 빈칸
                else if (c == '#') graph[i][j] = 1;    // 벽
                else graph[i][j] = c - '0' + 2;        // 유령
            }
        }
		
        // 1. 유령 상태 함수 생성
        int[][][] ghost = new int[4][N][M];
        for (int t = 0; t < 4; t++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    ghost[t][i][j] = graph[i][j];
                }
            }
        }
		
        // 2. 유령 상태 함수 업데이트
        for (int dir = 0; dir < 4; dir++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (graph[i][j] >= 2) {
                        int d = graph[i][j] - 2; // 초기 유령 방향
                        int ny = i;
                        int nx = j;

                        while (true) {
                            ny += dy[(d + dir) % 4];
                            nx += dx[(d + dir) % 4];
                            if (ny < 0 || nx < 0 || ny >= N || nx >= M || graph[ny][nx] == 1 || graph[ny][nx] >= 2) {
                                break;
                            }
                            ghost[dir][ny][nx] = 6;
                        }
                    }
                }
            }
        }
        
        // 3. 방문 함수 설정
        int[][][] visited = new int[4][N][M];
        for (int t = 0; t < 4; t++) {
            for (int i = 0; i < N; i++) {
                Arrays.fill(visited[t][i], Integer.MAX_VALUE);
            }
        }

        // 4. 유령의 집 설정
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx, sy, 0, 0});
        visited[0][sx][sy] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int t = cur[2];
            int stay = cur[3];

            if (x == ex && y == ey) {
                System.out.println(t);
                return;
            }

            int nextT = (t + 1) % 4;

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && ghost[nextT][nx][ny] == 0 && visited[nextT][nx][ny] > t + 1) {
                    visited[nextT][nx][ny] = t + 1;
                    q.add(new int[]{nx, ny, t + 1, 0});
                }
            }

            if (stay < 3 && ghost[nextT][x][y] == 0 && visited[nextT][x][y] > t + 1) {
                visited[nextT][x][y] = t + 1;
                q.add(new int[]{x, y, t + 1, stay + 1});
            }
        }

        System.out.println("GG");
    }
}