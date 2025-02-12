import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] isVisited = new boolean[words.length];
        
        Queue<Word> q = new LinkedList<>();
        q.add(new Word(begin, 0));
        
        while(!q.isEmpty()) {
            Word current = q.poll();
            String currentStr = current.str;
            
            if (currentStr.equals(target)) {
                return current.count;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (!isVisited[i]) {
                    String word = words[i];
                    int diff = 0;
                    
                    for (int j = 0; j < word.length(); j++) {
                        if (word.charAt(j) != currentStr.charAt(j)) {
                            diff++;
                        }
                    }
                    
                    // 한 글자만 다르면 큐에 추가
                    if (diff == 1) {
                        q.add(new Word(word, current.count + 1));
                        isVisited[i] = true;
                    }
                }
            }
        }
        
        return 0;
    }
    
    // 단어와 변환 횟수를 함께 저장하기 위한 클래스
    class Word {
        String str;
        int count;
        
        Word(String str, int count) {
            this.str = str;
            this.count = count;
        }
    }
}