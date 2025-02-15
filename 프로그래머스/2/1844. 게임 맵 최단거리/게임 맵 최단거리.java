import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};
        int N = maps.length;
        int M = maps[0].length;
        
        int[][] visited = new int[N][M];
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
                        
            for (int dir = 0; dir < 4; dir++) {
                int ny = tmp[0] + dy[dir];
                int nx = tmp[1] + dx[dir];
                
                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                
                if (maps[ny][nx] == 1 && visited[ny][nx] == 0) {
                    visited[ny][nx] = visited[tmp[0]][tmp[1]] + 1;
                    q.add(new int[] {ny , nx});
                }
            }
        }
        
        if (visited[N-1][M-1] != 0) answer = visited[N-1][M-1] + 1;
        
        return answer;
    }
}