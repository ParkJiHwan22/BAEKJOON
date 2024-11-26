import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static double ans;
    static int N;
    static boolean[] isC;
    static int[][] vector;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            isC = new boolean[N];
            vector = new int[N][2];
            int sumx = 0;
            int sumy = 0;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                vector[i][0] = Integer.parseInt(st.nextToken());
                vector[i][1] = Integer.parseInt(st.nextToken());
                sumx += vector[i][0];
                sumy += vector[i][1];
            }

            ans = Double.MAX_VALUE;
            rec(0,0, sumx, sumy);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);

    }

    static void rec(int cnt, int prev, int x, int y) {
        if(cnt == N / 2) {
            ans = Math.min(ans, Math.sqrt((double)x * x + (double)y * y));
            return;
        }
        for (int i = prev; i < N; i++) {
            rec(cnt + 1, i + 1, x - 2 * vector[i][0], y - 2 * vector[i][1]);
        }
    }
}