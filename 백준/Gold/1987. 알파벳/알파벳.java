import java.io.*;
import java.util.*;

public class Main {

    private static int[][] graph;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int R;
    private static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new int[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0 ; j < C; j++) {
                graph[i][j] = str.charAt(j) - 'A';
            }
        }

        boolean[] visited = new boolean[26];
        visited[graph[0][0]] = true;
        System.out.println(dfs(0, 0, visited, 1));
    }

    public static int dfs(int r, int c, boolean[] visited, int count) {
        int maxCount = count;

        for (int dir = 0; dir < 4; dir++) {
            int ny = r + dy[dir];
            int nx = c + dx[dir];

            if (ny >= 0 && ny < R && nx >= 0 && nx < C && !visited[graph[ny][nx]]) {
                visited[graph[ny][nx]] = true;
                maxCount = Math.max(maxCount, dfs(ny, nx, visited, count + 1));
                visited[graph[ny][nx]] = false;
            }
        }

        return maxCount;
    }
}