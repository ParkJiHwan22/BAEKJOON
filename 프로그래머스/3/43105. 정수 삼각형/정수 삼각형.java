import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        // 삼각형의 높이 구하기 - n
        int n = triangle.length;

        // n*n 배열을 만들고 더한 값을 저장하기(큰값만)
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < i+1; j++) {
                if (dp[i+1][j] < dp[i][j] + triangle[i+1][j]) {
                    dp[i+1][j] = dp[i][j] + triangle[i+1][j];
                }
                
                if (dp[i+1][j+1] < dp[i][j] + triangle[i+1][j+1]) {
                    dp[i+1][j+1] = dp[i][j] + triangle[i+1][j+1];
                }
            }
        }
        
        // 마지막 줄 중에 가장 큰 숫자 구하기        
        for (int i = 0; i < n; i++) {
            if ( answer < dp[n-1][i]) {
                answer = dp[n-1][i];
            }
        }
        
        return answer;
    }
}