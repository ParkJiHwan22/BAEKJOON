import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] cnt = new int[3];
        int size = 0;
        
        for (int i = 0; i < answers.length; i++) 
        {
            // 1번 수포자
            if (answers[i] == arr1[i % 5])
            {
                cnt[0] ++;
            }
            // 2번 수포자
            if (answers[i] == arr2[i % 8])
            {
                cnt[1] ++;
            }
            // 3번 수포자
            if (answers[i] == arr3[i % 10])
            {
                cnt[2] ++;
            }            
        }
        
        // 크기 정하기
        for (int i = 0; i < cnt.length; i++) 
        {
            if (Arrays.stream(cnt).max().getAsInt() == cnt[i]) 
            {
                size ++;
            }
        }
        
        // 답 넣기
        int[] answer = new int[size];
        int p = 0;
        for (int i = 0; i < cnt.length; i++) 
        {
            if (Arrays.stream(cnt).max().getAsInt() == cnt[i]) 
            {
                answer[p++] = i+1;
            }
        }
            
        return answer;
    }
}