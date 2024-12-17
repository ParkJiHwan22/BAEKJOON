import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 300001;
        int maxNum = 0;
        
        for (int i = 0; i < diffs.length; i++) {
            if (maxNum < diffs[i]) maxNum = diffs[i];    
        }
        
        // level은 1부터 maxNum까지 이분탐색으로 해결
        int start = 1;
        int end = maxNum;
        int mid;
        
        while (start <= end) {
            mid = (start + end + 1) / 2;
            long res = (long) times[0];
            
            for (int i = 1; i < diffs.length; i++) {
                res += Math.max(0, diffs[i] - mid) * (times[i-1] + times[i]) + times[i];
            }
            
            if (limit < res) {  // 레벨을 키워야 함
                start = mid + 1;
            } else {
                if (answer > mid) {
                    answer = mid;
                }
                end = mid - 1;
            }
        }
        
        
        
        return answer;
    }
}