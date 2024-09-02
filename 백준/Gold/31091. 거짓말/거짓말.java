import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        int[] arr = new int[N + 2]; // 누적합
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(st.nextToken());
            if (k <= 0) {
                arr[0] += 1;
                arr[-k + 1] -= 1;
            } else {
                arr[k] += 1;
                arr[N+1] -= 1;
            }
        }
        for (int i = 0; i <= N; i++) arr[i+1] += arr[i];
        for (int i = 0; i <= N; i++) {
            if (N - i == arr[i]) {
                sb.append(i).append(" ");
                cnt ++;
            }
        }

        System.out.println(cnt);
        System.out.println(sb);
    }
}