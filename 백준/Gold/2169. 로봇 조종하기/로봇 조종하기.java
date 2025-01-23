import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};

        int[][] matrix = new int[N][M];
        int[][][] res = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(res[i][j], -100000000);
            }
        }

        // 1. 한 층씩 계산
        // 2. q에 값을 넣고 왼쪽, 오른쪽으로 이동할 수 있게 함
        // 3. 왼쪽일 때 넣어두는 칸, 오른쪽일 때 값을 넣어주는 칸
        for (int i = 0; i < N; i++) {
            Queue<Integer> lq = new LinkedList<>();
            Queue<Integer> rq = new LinkedList<>();

            if (i > 0) {
                for (int j = 0; j < M; j++) {
                    res[i][j][0] = Math.max(res[i-1][j][0], res[i-1][j][1]) + matrix[i][j];
                    res[i][j][1] = Math.max(res[i-1][j][0], res[i-1][j][1]) + matrix[i][j];
                }
            } else {
                res[0][0][1] = matrix[0][0];
            }

            for (int j = M-1; j > 0; j--) {
                if(res[i][j-1][0] < res[i][j][0] + matrix[i][j-1]) {
                    res[i][j-1][0] = res[i][j][0] + matrix[i][j-1];
                }
            }

            for (int j = 0; j < M-1; j++) {
                if(res[i][j+1][1] < res[i][j][1] + matrix[i][j+1]) {
                    res[i][j+1][1] = res[i][j][1] + matrix[i][j+1];
                }
            }
        }

        System.out.println(Math.max(res[N-1][M-1][0], res[N-1][M-1][1]));
    }
}
