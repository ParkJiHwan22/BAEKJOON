import java.io.*;
import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
    
        
        int[][] phone = {{3, 1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}};
        int[] lPos = {3, 0};
        int[] rPos = {3, 2};
        
        // 탐색을 통해서 둘다 얼마나 걸렸는지 계산
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                lPos[0] = phone[numbers[i]][0];
                lPos[1] = phone[numbers[i]][1];
                answer += "L";
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                rPos[0] = phone[numbers[i]][0];
                rPos[1] = phone[numbers[i]][1];
                answer += "R";
            } else {
                int lLen = (Math.abs(lPos[0] - phone[numbers[i]][0])) + (Math.abs(lPos[1] - phone[numbers[i]][1]));
                int rLen = (Math.abs(rPos[0] - phone[numbers[i]][0])) + (Math.abs(rPos[1] - phone[numbers[i]][1]));
                
                // 어느손잡이인지에 따라 최종 결정하는 로직
                if (hand.equals("right")) {
                    if (lLen >= rLen) {
                        rPos[0] = phone[numbers[i]][0];
                        rPos[1] = phone[numbers[i]][1];                        
                        answer += "R";
                    } else {
                        lPos[0] = phone[numbers[i]][0];
                        lPos[1] = phone[numbers[i]][1];                 
                        answer += "L";
                    }
                } else {
                    if (lLen > rLen) {
                        rPos[0] = phone[numbers[i]][0];
                        rPos[1] = phone[numbers[i]][1];                        
                        answer += "R";
                    } else {
                        lPos[0] = phone[numbers[i]][0];
                        lPos[1] = phone[numbers[i]][1];  
                        answer += "L";
                    }
                }            
            }
        }

        return answer;
    }
}