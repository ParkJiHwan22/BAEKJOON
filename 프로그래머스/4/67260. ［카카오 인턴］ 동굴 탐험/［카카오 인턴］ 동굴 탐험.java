import java.util.*;

class Solution {
    public boolean solution(int n, int[][] path, int[][] order) {
        // 양방향 그래프 구성
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] p : path) {
            graph[p[0]].add(p[1]);
            graph[p[1]].add(p[0]);
        }
        
        // 선행 방문 조건을 저장하는 맵
        int[] before = new int[n];
        int[] after = new int[n];
        Arrays.fill(before, -1);
        Arrays.fill(after, -1);
        
        // 방문 순서 조건 저장
        for (int[] o : order) {
            if (o[1] == 0) return false; // 시작점에 제한이 있으면 불가능
            before[o[1]] = o[0];  // o[1]번 방은 o[0]번 방을 먼저 방문해야 함
            after[o[0]] = o[1];   // o[0]번 방 다음에 방문 가능한 방
        }
        
        // 방문 여부를 체크하는 배열
        boolean[] visited = new boolean[n];
        // 방문은 했지만 선행 조건이 충족되지 않은 방들을 저장
        boolean[] waiting = new boolean[n];
        
        // BFS를 위한 큐
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            if (visited[current]) continue;
            
            // 현재 방의 선행 방문 조건 체크
            if (before[current] != -1 && !visited[before[current]]) {
                waiting[current] = true;
                continue;
            }
            
            // 방문 처리
            visited[current] = true;
            
            // 현재 방문으로 인해 갈 수 있게 된 방 체크
            if (after[current] != -1 && waiting[after[current]]) {
                queue.add(after[current]);
            }
            
            // 인접한 방들을 큐에 추가
            for (int next : graph[current]) {
                if (!visited[next]) {
                    queue.add(next);
                }
            }
        }
        
        // 모든 방을 방문했는지 확인
        for (boolean v : visited) {
            if (!v) return false;
        }
        
        return true;
    }
}