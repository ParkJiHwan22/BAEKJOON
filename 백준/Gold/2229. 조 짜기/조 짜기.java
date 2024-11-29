import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            score[i+1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+1];
        for (int i = 2; i <score.length ; i++) {
            int minNum = Integer.MAX_VALUE;
            int maxNum = Integer.MIN_VALUE;
            for (int j = i; j >= 1 ; j--) {
                maxNum = Math.max(maxNum, score[j]);
                minNum = Math.min(minNum, score[j]);
                dp[i]=Math.max(dp[i],maxNum - minNum + dp[j-1]);
            }
        }
        System.out.println(dp[n]);
    }
}