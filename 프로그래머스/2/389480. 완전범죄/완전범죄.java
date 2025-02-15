import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int answer = -1;

        int[] dp = new int[n]; // B도둑이 훔치는 값, 인덱스는 A도둑의 훔치는 값
        Arrays.fill(dp, -1);
        dp[0] = 0;
                
        for (int i = 0; i < info.length; i++) {
            int[] tmp = new int[n];
            Arrays.fill(tmp, -1);
            
            for (int j = 0; j < n; j++) {
                if ( dp[j] >= 0) {
                    if (j + info[i][0] < n) tmp[j + info[i][0]] = dp[j]; // A도둑이 도둑질
                    if (tmp[j] >= 0) tmp[j] = Math.min(tmp[j], dp[j] + info[i][1]);
                    else tmp[j] = dp[j] + info[i][1];
                }   
            }
            
            for (int j = 0; j < n; j++) {
                dp[j] = tmp[j];
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (dp[i] < m && dp[i] >= 0) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}