import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {        
        int[][] map = new int[n+1][m+1];
        int[][] dp = new int[n+1][m+1];
        dp[1][1] = 1;
        
        for (int[] puddle : puddles) {
            map[puddle[1]][puddle[0]] = 1;   
        }
        
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                // 아래, 옆 둘다 보내야 함
                if (i != n && map[i+1][j] != 1) {
                    dp[i+1][j] = (dp[i][j] + dp[i+1][j]) % 1000000007;
                }
                if (j != m && map[i][j+1] != 1) {
                    dp[i][j+1] = (dp[i][j] + dp[i][j+1]) % 1000000007;
                }
            }
        }
        
        return dp[n][m];
    }
}