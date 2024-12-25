import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};
        int Y = board.length;
        int X = board[0].length;
        int[][][] map = new int[Y][X][2];
        // 앞부분만 저장하고 지금 가로인지 세로인지만 저장한다면?
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 1, 0, 0}); // y1, x1, 가로, 시간
        
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int y1 = tmp[0];
            int x1 = tmp[1];
            int y2 = tmp[0];
            int x2 = tmp[1];
            int rc = tmp[2];
            int time = tmp[3];
            
            if (rc == 0) x2 --; // 가로일 경우
            else y2 --; // 세로일 경우
            
            if (y1 == Y - 1 && x1 == X - 1) {
                answer = time;
                break;
            }
            
            // 상하좌우 이동
            for (int dir = 0; dir < 4; dir++) {
                int ny1 = y1 + dy[dir];
                int nx1 = x1 + dx[dir];
                int ny2 = y2 + dy[dir];
                int nx2 = x2 + dx[dir];
                
                if (ny1 < 0 || ny1 >= Y || nx1 < 0 || nx1 >= X || ny2 < 0 || ny2 >= Y || nx2 < 0 || nx2 >= X) {
                    continue;
                }
                
                // 두칸 다 빈칸이고, 방문하지 않았을 경우 저장하고 q에 다시 넣음
                if (board[ny1][nx1] == 0 && board[ny2][nx2] == 0 && map[ny1][nx1][rc] == 0) {
                    map[ny1][nx1][rc] = time + 1;
                    q.add(new int[]{ny1, nx1, rc, time + 1});
                }
            }
            
            // 방향 전환 이동(뒷바퀴가 앞바퀴로 이동) +1, +1
            if ((y2 + 1 - rc) >= 0 && (y2 + 1 - rc) < Y && (x2 + rc) >= 0 && (x2 + rc) < X && board[y2 + 1 - rc][x2 + rc] == 0) {
                // 여기가 빈칸이고, 경계값 안에 있을 경우,한번 더 회전
                if ((y2 + 1) >= 0 && (y2 + 1) < Y && (x2 + 1) >= 0 && (x2 + 1) < X && map[y2+1][x2+1][(rc+1) % 2] == 0 && board[y2 + 1][x2 + 1] == 0) {
                    map[y2+1][x2+1][(rc+1) % 2] = time + 1;
                    q.add(new int[]{y2 + 1, x2 + 1, (rc + 1) % 2, time + 1});
                }
            }
            
            // 뒷바퀴가 뒷바퀴로 이동 -1, +1
            if ((y1 - 1) >= 0 && (y1 - 1) < Y && (x1- 1) >= 0 && (x1- 1) < X && board[y1 - 1][x1 - 1] == 0) {
                // 여기가 빈칸이고, 경계값 안에 있을 경우,한번 더 회전
                if ((y1 - 1 + rc) >= 0 && (y1 - 1 + rc) < Y && (x1 - rc) >= 0 && (x1 - rc) < X && map[y1][x1][(rc+1) % 2] == 0 && board[y1 - 1 + rc][x1 - rc] == 0) {
                    map[y1][x1][(rc+1) % 2] = time + 1;
                    q.add(new int[]{y1, x1, (rc + 1) % 2, time + 1});
                }
            }
            
            // 방향 전환 이동(앞바퀴가 뒷바퀴로 이동) -1, -1
            if ((y1 - 1 + rc) >= 0 && (y1 - 1 + rc) < Y && (x1 - rc) >= 0 && (x1 - rc) < X && board[y1 - 1 + rc][x1 - rc] == 0) {
                // 여기가 빈칸이고, 경계값 안에 있을 경우,한번 더 회전
                if ((y1 - 1) >= 0 && (y1 - 1) < Y && (x1 - 1) >= 0 && (x1 - 1) < X && map[y2][x2][(rc+1) % 2] == 0 && board[y1 - 1][x1 - 1] == 0) {
                    map[y2][x2][(rc+1) % 2] = time + 1;
                    q.add(new int[]{y2, x2, (rc + 1) % 2, time + 1});
                }
            }

            // 방향 전환 이동(앞바퀴가 앞바퀴로 이동) +1, -1
            if ((y2 + 1) >= 0 && (y2 + 1) < Y && (x2 + 1) >= 0 && (x2 + 1) < X && board[y2 + 1][x2 + 1] == 0) {
                // 여기가 빈칸이고, 경계값 안에 있을 경우,한번 더 회전
                if ((y2 + 1 - rc) >= 0 && (y2 + 1 - rc) < Y && (x2 + rc) >= 0 && (x2 + rc) < X && map[y2 + 1 - rc][x2 + rc][(rc+1) % 2] == 0 && board[y2 + 1 - rc][x2 + rc] == 0) {
                    map[y2 + 1 - rc][x2 + rc][(rc+1) % 2] = time + 1;
                    q.add(new int[]{y2 + 1 - rc, x2 + rc, (rc + 1) % 2, time + 1});
                }
            }

        }
        
        return answer;
    }
}
        