class Solution {
    static int answer = 0;
    static String[] vowels = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        answer = 0;
        dfs("", word);
        return answer;
    }
    
    private boolean dfs(String str, String target) {
        // 목표 단어를 찾으면 true 반환
        if (str.equals(target)) {
            return true;
        }
        
        // 길이가 5가 되면 더 이상 진행하지 않음
        if (str.length() == 5) {
            return false;
        }
        
        // 각 모음을 추가하며 탐색
        for (String vowel : vowels) {
            answer++;  // 단어 개수 증가
            if (dfs(str + vowel, target)) {
                return true;  // 찾았으면 종료
            }
        }
        
        return false;
    }
}