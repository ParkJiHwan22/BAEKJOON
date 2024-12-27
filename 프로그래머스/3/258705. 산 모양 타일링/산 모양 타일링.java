import java.util.*;

class Solution {
    public int solution(int n, int[] tops) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        if (tops[0] == 0) dp[1] = 3;
        else dp[1] = 4;
        
        for (int i = 1; i < n; i++) {
            if (tops[i] == 0) {
                if (dp[i] * 3 - dp[i-1] >= 0) {
                    dp[i+1] = dp[i] * 3 - dp[i-1];
                } else {
                    dp[i+1] = 10007 + (dp[i] * 3 - dp[i-1]);
                }
            } else {
                if (dp[i] * 4 - dp[i-1] >= 0) {
                    dp[i+1] = dp[i] * 4 - dp[i-1];
                } else {
                    dp[i+1] = 10007 + (dp[i] * 4 - dp[i-1]);
                }
            }
            
            if (dp[i+1] >= 10007) dp[i+1] %= 10007;
        }
                
        return dp[n];
    }
}

// 큰삼각형이랑 마름모 2개랑 갯수 차이가 나서 dp로 저장할 때 어려움이 있다.
// top 1이 들어올 때, a * 3 + 원래 있던 거 -1한 거
// 이렇게 가려면 일일이 한칸한칸 dp로 기록해두어야함
// 0 -> 3, 3-1
// 1 -> 4, 4-1

// 3 - 3000 이 나올 경우 어떻게 할 것인가?
// 30000 - 3000 이므로 270000이고 답은 7000이 나와야한다.