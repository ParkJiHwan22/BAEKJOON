import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        // 목표 알고력과 코딩력 찾기
        int maxAlp = 0;
        int maxCop = 0;
        
        for (int[] problem : problems) {
            maxAlp = Math.max(maxAlp, problem[0]);
            maxCop = Math.max(maxCop, problem[1]);
        }
        
        // 초기 알고력/코딩력이 목표보다 높은 경우 처리
        alp = Math.min(alp, maxAlp);
        cop = Math.min(cop, maxCop);
        
        // DP 배열 초기화
        int[][] dp = new int[maxAlp + 1][maxCop + 1];
        for (int i = 0; i <= maxAlp; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[alp][cop] = 0;
        
        // DP로 최단 시간 계산
        for (int i = alp; i <= maxAlp; i++) {
            for (int j = cop; j <= maxCop; j++) {
                if (dp[i][j] == Integer.MAX_VALUE) continue;
                
                // 1. 알고력 1 증가
                if (i + 1 <= maxAlp) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                }
                
                // 2. 코딩력 1 증가
                if (j + 1 <= maxCop) {
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                }
                
                // 3. 문제 풀기
                for (int[] p : problems) {
                    if (i >= p[0] && j >= p[1]) {  // 문제를 풀 수 있는 경우
                        int nextAlp = Math.min(maxAlp, i + p[2]);
                        int nextCop = Math.min(maxCop, j + p[3]);
                        dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], 
                                                       dp[i][j] + p[4]);
                    }
                }
            }
        }
        
        return dp[maxAlp][maxCop];
    }
}