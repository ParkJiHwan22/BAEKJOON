class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int minMax = 0;
        int maxMax = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            // 오른쪽이 크면
            if (sizes[i][0] <= sizes[i][1]) 
            {
                if (maxMax < sizes[i][1]) 
                {
                    maxMax = sizes[i][1];
                }

                if (minMax < sizes[i][0]) 
                {
                    minMax = sizes[i][0];
                }                
            } 
            // 왼쪽이 크면
            else 
            {
                if (maxMax < sizes[i][0]) 
                {
                    maxMax = sizes[i][0];
                }
                
                if (minMax < sizes[i][1]) 
                {
                    minMax = sizes[i][1];
                }                  
            }
        }
        
        answer = minMax * maxMax;
        
        return answer;
    }
}