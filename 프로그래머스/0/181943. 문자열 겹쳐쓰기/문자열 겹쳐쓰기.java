class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String head = my_string.substring(0,s);
        String tail = my_string.substring(s + overwrite_string.length(),my_string.length());
        String answer = head + overwrite_string + tail;
        
        return answer;
    }
}