import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        int lowH = num / w;
        int lowPos = num % w;
        if (lowPos != 0) lowH ++;
        if (lowPos == 0) lowPos = w;
        
        // 짝수일 경우
        if (lowH % 2 == 0) lowPos = w - lowPos;
        
        int topH = n / w;
        int topPos = n % w;
        if (topPos != 0) topH ++;
        if (topPos == 0) topPos = w;
        
        // 짝수일 경우
        if (topH % 2 == 0) topPos = w - topPos;

        System.out.println(topH + " " + topPos + " " + lowH + " " + lowPos);
        
        if (topH % 2 == 1) {
            if (topPos >= lowPos) answer = topH - lowH + 1;
            else answer = topH - lowH;
        } else {
            if (topPos <= lowPos) answer = topH - lowH + 1;
            else answer = topH - lowH;
        }
        
        
        return answer;
    }
}