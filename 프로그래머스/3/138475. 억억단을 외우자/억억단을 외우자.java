import java.util.*;

class Solution {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        
        // 에라토스테네스의 체?
        // 1 ~ 5,000,000 의 수를 쭉 늘어놓고 리스트 형태로 약수 값을 저장
        
        int[] cnt = new int[e+1];
        
        // 1. 체로 거른다.
        boolean[] visited = new boolean[e+1];
        
        for (int i = 2; i < (int) Math.sqrt(e) + 1; i++) {
            for (int j = 2; i * j <= e; j++) {
                visited[i * j] = true;    
            }
        }
        
        // 2. 방문처리가 안된 숫자에 cnt[숫자]++ 해준다.
        for (int i = 2; i <= e; i++) {
            for (int j = 1; i * j <= e; j++) {
                cnt[i * j]++;
            }
        }
        
        // 3-1. 뒤에서부터 쭉 훑어서 가장 큰 숫자만 저장해놓은 배열을 만든다. 시작점 기준
        int[] res = new int[e+1];
        int maxNum = -1;
        int number = 0;
        
        for (int i = e; i > 0; i--) {
            if (maxNum <= cnt[i]) {
                maxNum = cnt[i];
                res[i] = i;
                number = i; 
            } else {
                res[i] = number;
            }
        }
        
        for (int i = 0; i < starts.length; i++) {
            answer[i] = res[starts[i]];
        }
        
        
        return answer;
    }
}