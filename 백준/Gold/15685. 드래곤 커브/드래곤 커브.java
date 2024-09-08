import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        int cnt = 0;

        boolean[][] visited = new boolean[101][101];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            Deque<Integer> dq = new ArrayDeque<>();
            dq.add(d);

            // 드래곤 커브 키우기
            while (g > 0) {
                Stack<Integer> stack = new Stack<>();
                for (int l : dq) stack.add((l+1) % 4);

                while (!stack.isEmpty()) dq.add(stack.pop());
                g--;
            }

            while (!dq.isEmpty()) {
                int direction = dq.pollFirst();

                if (direction == 0) {
                    visited[y][x] = true;
                    x += 1;
                    visited[y][x] = true;
                } else if (direction == 1) {
                    visited[y][x] = true;
                    y -= 1;
                    visited[y][x] = true;
                } else if (direction == 2) {
                    visited[y][x] = true;
                    x -= 1;
                    visited[y][x] = true;
                } else if (direction == 3) {
                    visited[y][x] = true;
                    y += 1;
                    visited[y][x] = true;
                }
            }
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (visited[i][j] && visited[i][j+1] && visited[i+1][j] && visited[i+1][j+1]) {
                    cnt ++;
                }
            }
        }

        System.out.println(cnt);
    }
}
