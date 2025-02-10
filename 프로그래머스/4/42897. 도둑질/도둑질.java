import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int m = money.length;
        
        // 1 ~ N -1 로 구하고
        int[] dp = new int[m];
        dp[0] = money[0];
        dp[1] = money[1];
        dp[2] = dp[0] + money[2];
        
        for (int i = 3; i < m-1; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3]) + money[i];
        }
        
        // 2 ~ N 으로 하나 구하기
        int[] dp2 = new int[m];
        dp2[1] = money[1];
        dp2[2] = money[2];
        
        for (int i = 3; i < m; i++) {
            dp2[i] = Math.max(dp2[i-2], dp2[i-3]) + money[i];
        }
        answer = Math.max(Math.max(dp[m-3], dp[m-2]), Math.max(dp2[m-2], dp2[m-1]));

        return answer;
    }
}