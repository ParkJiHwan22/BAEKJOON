import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        int[][] ruleA = new int[H][W]; // 규칙 A 입력 받기
        for (int i = 0; i < H; i++) {
            String strNum = br.readLine();
            for (int j = 0; j < W; j++) {
                ruleA[i][j] = strNum.charAt(j) - '0';
            }
        }

        int[][] ruleB = new int[H][W]; // 규칙 B 입력 받기
        for (int i = 0; i < H; i++) {
            String strNum = br.readLine();
            for (int j = 0; j < W; j++) {
                ruleB[i][j] = strNum.charAt(j) - '0';
            }
        }
        
        int[][] visited = new int[H][W];
        int[][] enterDir = new int[H][W];
        int cnt = 0;
        int ans = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {R, C, D});
        
        while (!queue.isEmpty()) {
            int tmp[] = new int[3];
            tmp = queue.poll();
            int y = tmp[0];
            int x = tmp[1];
            int d = tmp[2];
            
            if (y >= 0 && y < H && x >= 0 && x < W) {
                if (visited[y][x] == 0) { // 방문하지 않은 경우
                	int nd = (d + ruleA[y][x]) % 4;
                	int ny = y + dy[nd];
                	int nx = x + dx[nd];
                	ans += cnt + 1;
                	cnt = 0;
                	visited[y][x] = -1;
                	queue.add(new int[]{ny, nx, nd});
                	
                } else if (visited[y][x] != 0 && !(visited[y][x] == ans && enterDir[y][x] == d)) { // 1번 방문한 경우
                	visited[y][x] = ans;
                	enterDir[y][x] = d;
                	int md = (d + ruleB[y][x]) % 4;
                	int my = y + dy[md];
                	int mx = x + dx[md];
                	cnt++;
                	queue.add(new int[]{my, mx, md});
                }
                else { // 2번쨰 방문한 경우
                	break;
                }
            }
        }
        
        System.out.println(ans);
    }    
}