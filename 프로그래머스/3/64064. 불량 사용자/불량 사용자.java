import java.util.*;

class Solution {
    private Set<String> result;
    private String[] bannedId;
    
    public int solution(String[] user_id, String[] banned_id) {
        this.bannedId = banned_id;
        this.result = new HashSet<>();
        
        // banned_id 각각에 대해 매칭되는 user_id들을 찾아서 저장
        List<List<String>> matchingIds = new ArrayList<>();
        for (String pattern : banned_id) {
            List<String> matches = new ArrayList<>();
            for (String userId : user_id) {
                if (isMatch(userId, pattern)) {
                    matches.add(userId);
                }
            }
            matchingIds.add(matches);
        }
        
        // 가능한 모든 조합을 찾음
        findCombinations(matchingIds, new LinkedHashSet<>(), 0);
        
        return result.size();
    }
    
    // 문자열 패턴 매칭 검사
    private boolean isMatch(String userId, String pattern) {
        if (userId.length() != pattern.length()) {
            return false;
        }
        
        for (int i = 0; i < userId.length(); i++) {
            if (pattern.charAt(i) != '*' && pattern.charAt(i) != userId.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    // DFS를 사용하여 가능한 모든 조합을 찾음
    private void findCombinations(List<List<String>> matchingIds, Set<String> current, int depth) {
        if (depth == bannedId.length) {
            // 현재 조합을 정렬하여 문자열로 만들어 저장
            List<String> sorted = new ArrayList<>(current);
            Collections.sort(sorted);
            result.add(String.join(",", sorted));
            return;
        }
        
        // 현재 depth의 banned_id에 매칭되는 모든 user_id에 대해 시도
        for (String userId : matchingIds.get(depth)) {
            if (!current.contains(userId)) {
                current.add(userId);
                findCombinations(matchingIds, current, depth + 1);
                current.remove(userId);
            }
        }
    }
}