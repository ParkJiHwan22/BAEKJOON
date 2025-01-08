class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        
        long start = 1;
        long end =  Long.MAX_VALUE;
        
        while (start <= end) {
            long mid = start + (end - start) / 2;
            
            long sum = 0;
            for (int time : times) { 
                sum += mid / time;
                if (sum >= n) break; 
            }
            
            if (sum >= n) {
                answer = Math.min(answer, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return answer;
    }
}