import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int answer = -1;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        
        int yl = maps.length;
        int xl = maps[0].length();
        char[][] arr = new char[yl][xl]; // 미로
        int[][] visited = new int[yl][xl]; // 방문
        int sl = -1;
        int le = -1;
        
        // 배열 만들기
        for (int i = 0; i < yl; i++) {
            for (int j = 0; j < xl; j++) {
                arr[i][j] = maps[i].charAt(j);
                visited[i][j] = 0;
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        
        // S -> L
        for (int i = 0; i < yl; i++) {
            for (int j = 0; j < xl; j++) {
                if (arr[i][j] == 'S') {
                    q.add(new int[]{i, j});
                } 
            }
        }
        
        while(!q.isEmpty() && sl == -1) {
            int[] tmp = q.poll();
            
            for (int dir = 0; dir < 4; dir++) {
                int ny = tmp[0] + dy[dir];
                int nx = tmp[1] + dx[dir];
            
                if (nx < 0 || nx >= xl || ny < 0 || ny >= yl) continue;

                if (visited[ny][nx] == 0 && (arr[ny][nx] == 'O' || arr[ny][nx] == 'E')) {
                    visited[ny][nx] = visited[tmp[0]][tmp[1]] + 1;
                    q.add(new int[]{ny, nx});
                } else if (arr[ny][nx] == 'L') {
                    sl = visited[tmp[0]][tmp[1]] + 1;
                    break;
                }  
            }
        }
        
        // q 초기화
        q = new LinkedList<>();
        
        // visited 배열 초기화
        for (int i = 0; i < yl; i++) {
            for (int j = 0; j < xl; j++) {
                visited[i][j] = 0;
            }
        }
        
        // L -> E
        for (int i = 0; i < yl; i++) {
            for (int j = 0; j < xl; j++) {
                if (arr[i][j] == 'L') {
                    q.add(new int[]{i, j});
                } 
            }
        }
        
        while(!q.isEmpty() && le == -1) {
            int[] tmp = q.poll();
            
            for (int dir = 0; dir < 4; dir++) {
                int ny = tmp[0] + dy[dir];
                int nx = tmp[1] + dx[dir];
            
                if (nx < 0 || nx >= xl || ny < 0 || ny >= yl) continue;

                if (visited[ny][nx] == 0 && (arr[ny][nx] == 'O' || arr[ny][nx] == 'S')) {
                    visited[ny][nx] = visited[tmp[0]][tmp[1]] + 1;
                    q.add(new int[]{ny, nx});
                } else if (arr[ny][nx] == 'E') {
                    le = visited[tmp[0]][tmp[1]] + 1;
                    break;
                }  
            }
        }        
                
        // 답 구하기
        if (sl != -1 && le != -1) {
            answer = sl + le;
        }
                
        return answer;
    }
}
