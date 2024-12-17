import java.util.*;

class Solution {
    private static class Node {
        int prev, next;
        
        Node(int prev, int next) {
            this.prev = prev;
            this.next = next;
        }
    }
    
    public String solution(int n, int k, String[] cmd) {
        Node[] nodes = new Node[n];
        Stack<Integer> removed = new Stack<>();
        StringBuilder answer = new StringBuilder("O".repeat(n));
        
        // 이중 연결 리스트 초기화
        nodes[0] = new Node(-1, 1);
        for(int i = 1; i < n-1; i++) {
            nodes[i] = new Node(i-1, i+1);
        }
        nodes[n-1] = new Node(n-2, -1);
        
        int cur = k;  // 현재 선택된 위치
        
        for(String command : cmd) {
            switch(command.charAt(0)) {
                case 'U':
                    int up = Integer.parseInt(command.substring(2));
                    while(up-- > 0) {
                        cur = nodes[cur].prev;
                    }
                    break;
                    
                case 'D':
                    int down = Integer.parseInt(command.substring(2));
                    while(down-- > 0) {
                        cur = nodes[cur].next;
                    }
                    break;
                    
                case 'C':
                    removed.push(cur);
                    answer.setCharAt(cur, 'X');
                    
                    // 이전 노드와 다음 노드 연결
                    int prev = nodes[cur].prev;
                    int next = nodes[cur].next;
                    
                    if(prev != -1) nodes[prev].next = next;
                    if(next != -1) nodes[next].prev = prev;
                    
                    // 현재 위치 갱신
                    cur = (next == -1) ? prev : next;
                    break;
                    
                case 'Z':
                    int recoveredIdx = removed.pop();
                    answer.setCharAt(recoveredIdx, 'O');
                    
                    // 이전 노드와 다음 노드 복구
                    prev = nodes[recoveredIdx].prev;
                    next = nodes[recoveredIdx].next;
                    
                    if(prev != -1) nodes[prev].next = recoveredIdx;
                    if(next != -1) nodes[next].prev = recoveredIdx;
                    break;
            }
        }
        
        return answer.toString();
    }
}