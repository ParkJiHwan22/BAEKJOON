import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        PriorityQueue<Integer> pqA = new PriorityQueue<>();
        PriorityQueue<Integer> pqB = new PriorityQueue<>();
        
        for (int a : A) pqA.add(a);
        for (int b : B) pqB.add(b);
        
        while (!pqA.isEmpty() && !pqB.isEmpty()) {
            int a = pqA.poll();
            int b = pqB.poll();

            if (a < b) answer++;
            else pqA.add(a); 
        }
        
        return answer;
    }
}