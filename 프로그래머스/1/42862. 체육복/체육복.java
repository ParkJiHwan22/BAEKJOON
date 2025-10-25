import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] cntArr = new int[n+2];
        
        // 전부 1벌씩 있다고 가정
        for (int i = 0; i <= n+1; i++) {
            cntArr[i] = 1;
        }        
        
        // 잃어버린 애들 -1
        for (int i = 0; i < lost.length; i++) {
            cntArr[lost[i]] -= 1;
        }

        // 여벌 체육복 있는 애들 +1
        for (int i = 0; i < reserve.length; i++) {
            cntArr[reserve[i]] += 1;
        }

        // 2벌일 경우 앞, 뒤 순서로 없는 사람에게 체육복 제공
        for (int i = 1; i <= n; i++) {
            if (cntArr[i] == 2 && cntArr[i-1] == 0) {
                cntArr[i] -= 1;
                cntArr[i-1] += 1;
            } else if (cntArr[i] == 2 && cntArr[i+1] == 0) {
                cntArr[i] -= 1;
                cntArr[i+1] += 1;
            }
        }

        // 총 몇벌인지 체크
        for (int i = 1; i <= n; i++) {
            if (cntArr[i] >= 1) {
                answer ++;
            }
        }
              
        return answer;
    }
}