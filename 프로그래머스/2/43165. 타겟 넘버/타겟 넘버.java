import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        int[] dp = new int[2001];
        dp[1000] = 1;
        
        // 0 -> -1000, 1000 -> 0, 2000 -> 1000
        for (int i = 0; i < numbers.length; i++) {
            int[] tmp = new int[2001];
            
            for (int j = 0; j <= 2000; j++) {
                if (dp[j] > 0) {
                    tmp[j + numbers[i]] += dp[j];
                    tmp[j - numbers[i]] += dp[j];
                }    
            }
            
            for (int j = 0; j <= 2000; j++) {
                dp[j] = tmp[j];
            }
        }
        
        answer = dp[1000 + target];
        
        return answer;
    }
}