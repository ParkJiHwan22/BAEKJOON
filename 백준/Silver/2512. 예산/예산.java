import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int maxNum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (maxNum < arr[i]) maxNum = arr[i];
        }

        int M = Integer.parseInt(br.readLine());
        int[] dp = new int[maxNum+2];

        for (int k : arr) {
            for (int j = 1; j <= k; j++) {
                dp[j] ++;
            }
        }

        int total = 0;
        int idx = 0;
        while (idx <= maxNum) {
            if (total > M) break;

            total += dp[++idx];
        }

        System.out.println(idx-1);
    }
}
