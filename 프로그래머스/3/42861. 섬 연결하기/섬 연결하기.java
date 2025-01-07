import java.util.*;

class Solution {
    
    private static int[] p;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int len = 1;
        p = new int[n];
        
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        for (int[] cost : costs) {
            pq.add(cost);
        }
                
        while (len < n) {
            int[] tmp = pq.poll();
            int a = tmp[0];
            int b = tmp[1];
            
            if (union(a, b)) {
                answer += tmp[2];
                len++;
            }
            
            // System.out.println(Arrays.toString(p));
        }
        
        return answer;
    }
    
    public int find(int x) {
        if (x == p[x]) return x;
        else return p[x] = find(p[x]);
    }
    
    public boolean union(int a, int b) {
        int x = find(a);
        int y = find(b);
        
        if (x != y) {
            p[x] = y;
            return true;
        } else {
            return false;
        }
    }
}