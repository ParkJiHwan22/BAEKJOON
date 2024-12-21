import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};
        
        int n = land.length;
        int m = land[0].length;
        boolean[][] visited = new boolean[n][m];

        Map<Integer, Integer> posCnt = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});

                    visited[i][j] = true;
                    int cnt = 0;
                    
                    while(!q.isEmpty()) {
                        int[] tmp = q.poll();
                        land[tmp[0]][tmp[1]] = i * n + j + 2;
                        cnt++;
                        
                        for (int dir = 0; dir < 4; dir++) {
                            int ny = tmp[0] + dy[dir];
                            int nx = tmp[1] + dx[dir];
                            
                            if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                                continue;
                            }
                            
                            if (land[ny][nx] == 1 && !visited[ny][nx]) {
                                q.add(new int[]{ny, nx});
                                visited[ny][nx] = true;
                            }
                        
                        }
                    }
                    
                    posCnt.put(i * n + j + 2, cnt);
                }
            }
        }
        
        // 계산 part
        int answer = 0;

        for (int i = 0; i < m; i++) {
            int totalScore = 0;
            HashSet<Integer> hs = new HashSet<>();
            
            for (int j = 0; j < n; j++) {
                hs.add(land[j][i]);
            }
            
            for (int k : hs) {
                if (k != 0) {
                    totalScore += posCnt.get(k);
                }
            }
            
            if (answer < totalScore) {
                answer = totalScore;
            }
        }        
        
        return answer;
    }
}