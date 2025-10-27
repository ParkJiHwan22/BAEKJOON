class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        int t = (brown - 4) / 2;
        int start = 1;
        int end = t-1;
        
        while (start <= end) {
            if ((start * end) == yellow) {
                answer = new int[]{end + 2, start + 2};
                break;
            }
            
            start ++;
            end --;
        }
        
        
        return answer;
    }
}