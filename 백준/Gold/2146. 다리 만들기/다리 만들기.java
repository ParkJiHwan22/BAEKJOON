import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int minNum = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 각자 섬마다 숫자로 바꿈 1, 2, 3, 4, 5 ...
        int islandNum = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    islandNum ++;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[] {i, j});
                    map[i][j] = islandNum;
                    while (!q.isEmpty()) {
                        int[] tmp = q.poll();
                        int y = tmp[0];
                        int x = tmp[1];

                        for (int dir = 0; dir < 4; dir++) {
                            int ny = y + dy[dir];
                            int nx = x + dx[dir];

                            if (ny < n && ny >= 0 && nx < n && nx >= 0 && map[ny][nx] == 1) {
                                map[ny][nx] = islandNum;
                                q.add(new int[] {ny, nx});
                            }
                        }
                    }
                }
            }
        }

        // 2. 사방탐색 중에 0이 하나라도 있으면 q에 넣음
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int dir = 0; dir < 4; dir++) {
                    int ny = i + dy[dir];
                    int nx = j + dx[dir];

                    if (ny < n && ny >= 0 && nx < n && nx >= 0 && map[i][j] != 0 && map[ny][nx] == 0) { // 현재가 육지이고, 인접한 위치가 바다일 때
                        int curIslandNum = map[i][j];
                        q.add(new int[] {i, j});
                        int[][] visited = new int[n][n];
                        visited[i][j] = 1;

                        // 3. bfs로 돌다가 다른 대륙이 나오면 stop 최소거리를 저장
                        while (!q.isEmpty()) {
                            int[] tmp = q.poll();
                            int y = tmp[0];
                            int x = tmp[1];

                            for (int k = 0; k < 4; k++) {
                                int my = y + dy[k];
                                int mx = x + dx[k];

                                if (my < n && my >= 0 && mx < n && mx >= 0 && visited[my][mx] == 0 && map[my][mx] == 0) { // 방문 경험이 없고 바다일 때
                                    visited[my][mx] = visited[y][x] + 1;
                                    q.add(new int[] {my, mx});
                                } else if (my < n && my >= 0 && mx < n && mx >= 0 && visited[my][mx] == 0 && map[my][mx] != curIslandNum) { // 방문 경험이 없고 다른 육지일 때
                                    visited[my][mx] = visited[y][x] + 1;
                                    if (minNum > visited[my][mx]) {
                                        minNum = visited[my][mx];
                                    }
                                    break;
                                }
                            }
                        }
                        break;
                    }
                }
            }
        }

        System.out.println(minNum - 2);
    }
}
