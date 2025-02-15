import java.util.*;
class Solution {
    
    class Node implements Comparable<Node> {
        String comp;
        String num;
        public Node(String comp, String num) {
            this.comp = comp;
            this.num = num;
        }
        
        @Override
        public int compareTo(Node other) {
            return -this.comp.compareTo(other.comp);
        }
    }
    
    public String solution(int[] numbers) {
        String answer = "";
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int number : numbers) {
            String num = Integer.toString(number);
            String comp = num + num + num + num;  // 4자리로 맞추는 대신 반복
            comp = comp.substring(0, 4);  // 앞 4자리만 사용
            
            pq.add(new Node(comp, num));            
        }
        
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            answer += node.num;
        }
        
        // 모든 숫자가 0인 경우 처리
        if (answer.charAt(0) == '0') {
            return "0";
        }
        
        return answer;
    }
}