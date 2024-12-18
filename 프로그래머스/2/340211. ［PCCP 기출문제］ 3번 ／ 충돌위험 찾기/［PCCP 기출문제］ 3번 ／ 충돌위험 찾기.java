import java.util.*;
class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        Map<String, List<Integer>> timePosition = new HashMap<>();
        
        for (int robot = 0; robot < routes.length; robot++) {
            int totalTime = 0;
            
            for (int j = 0; j < routes[robot].length - 1; j++) {
                int[] curr = points[routes[robot][j] - 1];
                int[] next = points[routes[robot][j + 1] - 1];
                
                int r = curr[0];
                int c = curr[1];
                int time = totalTime;
                
                // 시작 위치
                String key = time + "," + r + "," + c;
                timePosition.computeIfAbsent(key, k -> new ArrayList<>()).add(robot);
                
                // r 좌표 이동
                while (r != next[0]) {
                    time++;
                    r += Integer.compare(next[0], r);
                    key = time + "," + r + "," + c;
                    timePosition.computeIfAbsent(key, k -> new ArrayList<>()).add(robot);
                }
                
                // c 좌표 이동
                while (c != next[1]) {
                    time++;
                    c += Integer.compare(next[1], c);
                    key = time + "," + r + "," + c;
                    timePosition.computeIfAbsent(key, k -> new ArrayList<>()).add(robot);
                }
                
                totalTime = time;
            }
        }
        
        // 충돌 체크
        for (List<Integer> robots : timePosition.values()) {
            if (robots.size() >= 2) {
                // 서로 다른 로봇이 있는지 확인
                Set<Integer> uniqueRobots = new HashSet<>(robots);
                if (uniqueRobots.size() >= 2) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}