class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int digit = storey % 10;  // 현재 자릿수
            int next = (storey / 10) % 10;  // 다음 자릿수
            
            if (digit > 5) {
                // 올림: 10 - digit 만큼 더해서 올림
                answer += (10 - digit);
                storey = storey / 10 + 1;
            } else if (digit < 5) {
                // 내림: digit 만큼 빼기
                answer += digit;
                storey /= 10;
            } else {  // digit == 5
                // 다음 자릿수가 5 이상이면 올림, 아니면 내림
                answer += 5;
                if (next >= 5) {
                    storey = storey / 10 + 1;
                } else {
                    storey /= 10;
                }
            }
        }
        
        return answer;
    }
}