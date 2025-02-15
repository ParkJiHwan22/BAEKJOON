import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] recentVisit = new int[26]; 
        Arrays.fill(recentVisit, -1);
        
        for (int i = 0; i < s.length(); i++) {
            if (recentVisit[s.charAt(i) -'a'] < 0) answer[i] = -1;
            else answer[i] = i - recentVisit[s.charAt(i) -'a'];

            recentVisit[s.charAt(i) -'a'] = i;
        }
        
        return answer;
    }
}