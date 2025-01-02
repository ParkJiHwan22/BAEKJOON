import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int maxInt = 0;
        int minInt = 200000001;
        
        for (int i = 0; i < stones.length; i++) {
            maxInt = Math.max(maxInt, stones[i]);
            minInt = Math.min(minInt, stones[i]);
        }
        
        int start = minInt - 1;
        int end = maxInt + 1;
        int mid = 0;
        
        while(start <= end) {
            mid = (start + end) / 2;
            boolean isTrue = true;
            int cum = 0;
                        
            for (int i = 0; i < stones.length; i++) {
                if (stones[i] < mid) cum++;
                else cum = 0;
                
                if (cum == k) {
                    isTrue = false;
                    break;
                }
            }
            
            if (isTrue) {
                if (answer < mid) {
                    answer = mid;    
                }
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            
            // System.out.println(mid + " " + start + " " + end);
        }
        
        return answer;
    }
}