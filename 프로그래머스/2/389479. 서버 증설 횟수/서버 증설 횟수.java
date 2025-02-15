import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        // m : 증설인원 조건, k : 빌리는 시간
        
        // 서버의 수
        Deque<Integer> server = new ArrayDeque<>();
        
        for (int player : players) {
            int capa = server.size();
            
            if (capa < (player / m)) {
                int t = (player / m) - capa;
                
                for (int i = 0; i < t; i++) {
                    server.addFirst(k);
                    answer ++;
                }
            }

            int size = server.size();
            for (int i = 0; i < size; i++) {
                int current = server.poll();
                server.offer(current - 1);
            }
            
            while (!server.isEmpty()) {
                if (server.peekLast() == 0) {
                    server.pollLast();
                } else {
                    break;
                }
            }            
        }
        
        return answer;
    }
}