class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;

        int[] dp = new int[86400];
        boolean[] sup = new boolean[86400];
        
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 60; j++) {
                boolean hCnt = false;
                boolean mCnt = false;
                
                for (int k = 0; k < 60; k++) {
                    int hour = (i % 12) * 3600 + j * 60 + k;
                    int minute = j * 720 + k * 12;
                    int second = k * 720;

                    if ((i % 12) == 0 && j == 0 && k == 0) {
                        if (i == 0) dp[i * 3600 + j * 60 + k] = 1;
                        else dp[i * 3600 + j * 60 + k] = dp[i * 3600 + j * 60 + k - 1] + 1;
                        hCnt = true;
                        mCnt = true;
                        sup[i * 3600 + j * 60 + k] = true;
                    } else {
                        dp[i * 3600 + j * 60 + k] = Math.max(dp[i * 3600 + j * 60 + k], dp[i * 3600 + j * 60 + k - 1]);
                        
                        if (!mCnt && second > minute) {
                            dp[i * 3600 + j * 60 + k]++;
                            mCnt = true;
                        } else if (!mCnt && second == minute) {
                            dp[i * 3600 + j * 60 + k]++;
                            mCnt = true;
                            sup[i * 3600 + j * 60 + k] = true;
                        }

                        if (!hCnt && second > hour) {
                            dp[i * 3600 + j * 60 + k]++;
                            hCnt = true;
                        } else if (!mCnt && second == hour) {
                            dp[i * 3600 + j * 60 + k]++;
                            hCnt = true;
                            sup[i * 3600 + j * 60 + k] = true;
                        }

                    }
                }                    
                
                int hour = (i % 12) * 3600 + j * 60 + 60;
                int minute = j * 720 + 720;
                int second = 43200;

                if (!hCnt && second > hour) {
                    dp[i * 3600 + j * 60 + 60] = dp[i * 3600 + j * 60 + 59] + 1;
                    hCnt = true;
                }

            }
        }
        
        if (sup[h1 * 3600 + m1 * 60 + s1]) answer++;
        answer += dp[h2 * 3600 + m2 * 60 + s2] - dp[h1 * 3600 + m1 * 60 + s1];
          
        return answer;
    }
}