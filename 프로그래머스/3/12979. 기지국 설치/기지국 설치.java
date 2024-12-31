class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int befNum = 1;
        
        for (int station : stations) {
            if (station - w > befNum) {
                if ((station - w - befNum) % (w * 2 + 1) != 0) {
                    answer += (station - w - befNum) / (w * 2 + 1) + 1;
                } else {
                    answer += (station - w - befNum) / (w * 2 + 1);
                }
            }
            
            befNum = station + w + 1;
        }
        
        if (n+1 > befNum) {
            if ((n + 1 - befNum) % (w * 2 + 1) != 0) {
                answer += (n + 1 - befNum) / (w * 2 + 1) + 1;
            } else {
                answer += (n + 1 - befNum) / (w * 2 + 1);
            }
        }
        
        return answer;
    }
}