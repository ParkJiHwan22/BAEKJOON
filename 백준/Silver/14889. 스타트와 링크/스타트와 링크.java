import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int minInt = Integer.MAX_VALUE;
    private static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        matrix = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] visited = new boolean[N];
        combinations(visited, 0, N / 2);
        System.out.println(minInt);
    }

    public static void combinations(boolean[] visited, int start, int r) {
        if (r == 0) {
            check(visited);
        } else {
            for (int i = start; i < N; i++) {
                visited[i] = true;
                combinations(visited, i + 1, r - 1);
                visited[i] = false;
            }
        }
    }

    public static void check(boolean[] visited) {
        int resTrue = 0;
        int resFalse = 0;

        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    resTrue += matrix[i][j] + matrix[j][i];
                } else if (!visited[i] && !visited[j]) {
                    resFalse += matrix[i][j] + matrix[j][i];
                }
            }
        }

        if (Math.abs(resTrue - resFalse) < minInt) minInt = Math.abs(resTrue - resFalse);
    }
}
