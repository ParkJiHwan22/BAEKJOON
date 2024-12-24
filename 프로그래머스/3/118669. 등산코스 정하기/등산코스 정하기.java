import java.util.*;

class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[] {1000000000, 1000000000};
        int[] visited = new int[n+1];
        Arrays.fill(visited, Integer.MAX_VALUE);

        // 시작점 기록
        for (int i = 0; i < gates.length; i++) {
            visited[gates[i]] = -1;
        }
        
        // 끝점 기록
        for (int i = 0; i < summits.length; i++) {
            visited[summits[i]] = -2;
        }
        
        List<List<int[]>> arr = new ArrayList<List<int[]>>();
        
        for (int i = 0; i < n+1; i++) {
            arr.add(new ArrayList<int[]>());
        }

        for (int i = 0; i < paths.length; i++) {
            arr.get(paths[i][0]).add(new int[]{paths[i][1], paths[i][2]});
            arr.get(paths[i][1]).add(new int[]{paths[i][0], paths[i][2]});
        }
        
        for (int i = 0; i < gates.length; i++) {
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[] {gates[i], 0});
        
            while(!q.isEmpty()) {
                int[] tmp = q.poll();
                
                for (int[] tmpNums : arr.get(tmp[0])) {
                    if (visited[tmpNums[0]] == -1) { // 시작점일 경우
                        continue;
                    } else if (visited[tmpNums[0]] == -2) { // 끝점일 경우
                        if (answer[1] > Math.max(tmp[1], tmpNums[1])) {
                            answer[0] = tmpNums[0];
                            answer[1] = Math.max(tmp[1], tmpNums[1]);
                        } else if (answer[1] == Math.max(tmp[1], tmpNums[1]) && answer[0] > tmpNums[0]) {
                            answer[0] = tmpNums[0];
                        }
                    } else if (visited[tmpNums[0]] > Math.max(tmp[1], tmpNums[1])) { // 쉼터일 경우
                        visited[tmpNums[0]] = Math.max(tmp[1], tmpNums[1]);
                        q.add(new int[]{tmpNums[0], visited[tmpNums[0]]});
                    }
                }
            }
        }
        
        return answer;
    }
}