import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());    
        int[][] map = new int[N][M];
        int[] start = new int[5];
        
        // 이차원 배열로 map 만들기
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = str.charAt(j);
                if (c == '#') map[i][j] = -1;    // 벽
                else if (c == '.') map[i][j] = 0;    
                else if (c == 'R') {
                    start[0] = i;
                    start[1] = j;
                }
                else if (c == 'B') {
                    start[2] = i;
                    start[3] = j;
                }
                else if (c == 'O') map[i][j] = 3; // 출구
            }
        }
                
        boolean[][][][] visited = new boolean[N][M][N][M];
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        visited[start[0]][start[1]][start[2]][start[3]] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            if (cur[4] > 9) {
                System.out.println(0);
                return;
            }
            
            for (int dir = 0; dir < 4; dir++) {
                int ry = cur[0], rx = cur[1];
                int by = cur[2], bx = cur[3];
                boolean redOut = false, blueOut = false;
                
                // 왼쪽으로 기울이기
                if (dir == 0) {
                    if (rx <= bx) {
                        rx = moveLeft(map, ry, rx, by, bx, true);
                        if (rx == -1) redOut = true;
                        
                        bx = moveLeft(map, by, bx, ry, rx, false);
                        if (bx == -1) blueOut = true;
                    } else {
                        bx = moveLeft(map, by, bx, ry, rx, false);
                        if (bx == -1) blueOut = true;
                        
                        rx = moveLeft(map, ry, rx, by, bx, true);
                        if (rx == -1) redOut = true;
                    }
                }
                // 오른쪽으로 기울이기
                else if (dir == 1) {
                    if (rx >= bx) {
                        rx = moveRight(map, ry, rx, by, bx, true);
                        if (rx == -1) redOut = true;
                        
                        bx = moveRight(map, by, bx, ry, rx, false);
                        if (bx == -1) blueOut = true;
                    } else {
                        bx = moveRight(map, by, bx, ry, rx, false);
                        if (bx == -1) blueOut = true;
                        
                        rx = moveRight(map, ry, rx, by, bx, true);
                        if (rx == -1) redOut = true;
                    }
                }
                // 위로 기울이기
                else if (dir == 2) {
                    if (ry <= by) {
                        ry = moveUp(map, ry, rx, by, bx, true);
                        if (ry == -1) redOut = true;
                        
                        by = moveUp(map, by, bx, ry, rx, false);
                        if (by == -1) blueOut = true;
                    } else {
                        by = moveUp(map, by, bx, ry, rx, false);
                        if (by == -1) blueOut = true;
                        
                        ry = moveUp(map, ry, rx, by, bx, true);
                        if (ry == -1) redOut = true;
                    }
                }
                // 아래로 기울이기
                else {
                    if (ry >= by) {
                        ry = moveDown(map, ry, rx, by, bx, true);
                        if (ry == -1) redOut = true;
                        
                        by = moveDown(map, by, bx, ry, rx, false);
                        if (by == -1) blueOut = true;
                    } else {
                        by = moveDown(map, by, bx, ry, rx, false);
                        if (by == -1) blueOut = true;
                        
                        ry = moveDown(map, ry, rx, by, bx, true);
                        if (ry == -1) redOut = true;
                    }
                }
                
                if (redOut && !blueOut) {
                    System.out.println(1);
                    return;
                }
                
                if (blueOut) continue;
                
                if (!redOut && !blueOut) {
                    if (!visited[ry][rx][by][bx] && (ry != by || rx != bx)) {
                        visited[ry][rx][by][bx] = true;
                        q.add(new int[]{ry, rx, by, bx, cur[4] + 1});
                    }
                }
            }
        }
        System.out.println(0);
    }
    
    private static int moveLeft(int[][] map, int y, int x, int oy, int ox, boolean isRed) {
        while (map[y][x - 1] != -1) {
            if (map[y][x - 1] == 3) return -1;
            if (y == oy && x - 1 == ox) break;
            x--;
        }
        return x;
    }
    
    private static int moveRight(int[][] map, int y, int x, int oy, int ox, boolean isRed) {
        while (map[y][x + 1] != -1) {
            if (map[y][x + 1] == 3) return -1;
            if (y == oy && x + 1 == ox) break;
            x++;
        }
        return x;
    }
    
    private static int moveUp(int[][] map, int y, int x, int oy, int ox, boolean isRed) {
        while (map[y - 1][x] != -1) {
            if (map[y - 1][x] == 3) return -1;
            if (y - 1 == oy && x == ox) break;
            y--;
        }
        return y;
    }
    
    private static int moveDown(int[][] map, int y, int x, int oy, int ox, boolean isRed) {
        while (map[y + 1][x] != -1) {
            if (map[y + 1][x] == 3) return -1;
            if (y + 1 == oy && x == ox) break;
            y++;
        }
        return y;
    }
}