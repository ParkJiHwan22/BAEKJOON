import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        int[] visited = new int[1000001];
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, 0});
        
        while(!q.isEmpty()) {
            int[] tmp = q.poll(); // x, cnt
            int num = tmp[0];
            int cnt = tmp[1];
            
            if (num == y) {
                return cnt;
            }
            
            if (num + n <= 1000000 && visited[num + n] == 0) {
                visited[num + n] = cnt;
                q.add(new int[]{num + n, cnt+1});
            }

            if (num * 2 <= 1000000 && visited[num * 2] == 0) {
                visited[num * 2] = cnt;
                q.add(new int[]{num * 2, cnt+1});
            }               

            if (num * 3 <= 1000000 && visited[num * 3] == 0) {
                visited[num * 3] = cnt;
                q.add(new int[]{num * 3, cnt+1});
            }    

        }    
        
        return answer;
    }
}