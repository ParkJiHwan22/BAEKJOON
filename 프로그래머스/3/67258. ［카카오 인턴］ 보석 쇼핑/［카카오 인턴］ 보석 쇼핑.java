import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {1, gems.length};
        
       // 모든 보석 종류를 Set에 저장
        Set<String> gemTypes = new HashSet<>(Arrays.asList(gems));
        int total = gemTypes.size();
                
        // 현재 구간에 포함된 보석들의 개수를 저장
        Map<String, Integer> current = new HashMap<>();
        
        int start = 0;
        int minLength = gems.length;
        
        // 투포인터로 구간 관리
        for (int end = 0; end < gems.length; end++) {
            // end 위치의 보석 추가
            current.put(gems[end], current.getOrDefault(gems[end], 0) + 1);
            
           // 현재 구간에 모든 종류의 보석이 포함되어 있다면
            while (current.size() == total) {
                // 더 짧은 구간을 찾았다면 정답 갱신
                if (end - start < minLength) {
                    answer[0] = start + 1;
                    answer[1] = end + 1;
                    minLength = end - start;
                }
                
                // start 위치의 보석 제거
                String gemToRemove = gems[start];
                int count = current.get(gemToRemove);
                if (count == 1) {
                    current.remove(gemToRemove);
                } else {
                    current.put(gemToRemove, count - 1);
                }
                start++;
            }
        }
        
        return answer;
    }
}