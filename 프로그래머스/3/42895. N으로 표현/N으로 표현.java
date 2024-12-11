import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) {
            return 1;
        }
        
        // 1부터 8까지의 횟수별로 가능한 숫자들을 저장할 List<Set> 생성
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }
                
        // 이어붙여서 만든 숫자 먼저 저장(N, NN, NNN ...)
        for (int i = 1; i <= 8; i++) {
            int c = 0;
            for (int j = 0; j < i; j++) {
                c = c * 10 + N;
            }
            dp.get(i).add(c);
        }
                
        // 사칙연산으로 만들 수 있는 모든 숫자 계산
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j < i; j++) {
                for (int a : dp.get(j)) {
                    for (int b : dp.get(i - j)) {
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);
                        if (b != 0) {
                            dp.get(i).add(a / b);
                        }
                    }
                }
            }
            
            if (dp.get(i).contains(number)) {
                return i;
            }
        }
                
        return -1;
    }
}