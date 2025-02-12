import java.util.*;

class Solution {
    public int solution(int[][] maze) {
        int answer = 0;
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};
        int N = maze.length;
        int M = maze[0].length;
        
        // 모든 정보를 가지고 다닌다면?
        // [y1, x1, y2, x2, 이진수로 1번 지나온 길 저장, 이진수로 2번 지나온 길 저장]
        int[] info = new int[39];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maze[i][j] == 1) {
                    info[0] = i;
                    info[1] = j;
                } else if(maze[i][j] == 2) {
                    info[2] = i;
                    info[3] = j;
                }
            }
        }
        
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(info);
        
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            
            if (tmp[37] == 1 && tmp[38] == 1) {
                answer = tmp[36];
                break;
            }
            
            for (int dir1 = 0; dir1 < 4; dir1 ++) {
                int ny1 = tmp[0];
                int nx1 = tmp[1];  
                if (tmp[37] == 0) {
                    ny1 += dy[dir1];
                    nx1 += dx[dir1];
                }
                
                for (int dir2 = 0; dir2 < 4; dir2 ++) {
                    int ny2 = tmp[2];
                    int nx2 = tmp[3];
                    if (tmp[38] == 0) {
                        ny2 += dy[dir2];
                        nx2 += dx[dir2];
                    }
                    
                    // 벽을 넘지 않을 것
                    if (ny1 < 0 || ny1 >= N || nx1 < 0 || nx1 >= M || ny2 < 0 || ny2 >= N || nx2 < 0 || nx2 >= M) {
                        continue;
                    }
                    
                    // 장애물을 지나지 않을 것
                    if (maze[ny1][nx1] == 5 || maze[ny2][nx2] == 5) {
                        continue;
                    }
                    
                    // 서로 교차할 경우
                    if ((ny1 == tmp[2] && nx1 == tmp[3]) && (ny2 == tmp[0] && nx2 == tmp[1])) {
                        continue;
                    }
                    
                    // 서로 같은 점에서 만날 경우
                    if (ny1 == ny2 && nx1 == nx2) {
                        continue;
                    }
                    
                    // 지나온 길이 아닐 것
                    // 이진수로 변환해서 해당 좌표가 지나온 값인지 확인(4~19, 20~35)
                    // 둘다 지나온 값이 아니면 마킹하고 다시 큐에 넣음
                    if (tmp[37] == 0 && tmp[ny1 * M + nx1 + 4] == 1) {
                        continue;
                    }
                    
                    if (tmp[38] == 0 && tmp[ny2 * M + nx2 + 20] == 1) {
                        continue;
                    }
                    
                    int[] tmpNext = new int[39];
                    for (int i = 0; i < 39; i++) tmpNext[i] = tmp[i];                        
                    
                    // 도착칸에 도착할 경우
                    if (maze[ny1][nx1] == 3) tmpNext[37] = 1;
                    if (maze[ny2][nx2] == 4) tmpNext[38] = 1;
                    
                    tmpNext[tmp[0] * M + tmp[1] + 4] = 1;
                    tmpNext[tmp[2] * M + tmp[3] + 20] = 1;
                    tmpNext[0] = ny1;
                    tmpNext[1] = nx1;
                    tmpNext[2] = ny2;
                    tmpNext[3] = nx2;
                    tmpNext[36] ++;
                    
                    q.add(tmpNext);
                }
            }
        }
        
        return answer;
    }
}