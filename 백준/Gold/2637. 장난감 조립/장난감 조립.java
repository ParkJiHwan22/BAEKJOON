import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][N + 1]; // 부품 개수 저장
        boolean[] isBasic = new boolean[N + 1]; // 기본 부품 여부
        Arrays.fill(isBasic, true);

        int[] inDegree = new int[N + 1]; // 진입 차수
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 진출 차수
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(b).add(a);
            dp[a][b] = c;
            isBasic[a] = false;
            inDegree[a]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int q = queue.poll();

            for (int next : graph.get(q)) {
                for (int i = 1; i <= N; i++) {
                    dp[next][i] += dp[q][i] * dp[next][q];
                }

                inDegree[next]--;
                if (inDegree[next] == 0) queue.add(next);
            }
        }

        for (int i = 1; i <= N; i++) {
            if (isBasic[i]) {
                System.out.println(i + " " + dp[N][i]);
            }
        }
    }
}