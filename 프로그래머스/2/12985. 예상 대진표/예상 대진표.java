class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        if ((a - 1) / (n / 2) != (b - 1) / (n / 2)) {
            while (n / 2 != 1) {
                n /= 2; 
                answer++;
            }
        } else {
            while (true) {
                if ((a - 1) / 2 == (b - 1) / 2) {
                    break;
                } else {
                    a = a / 2 + a % 2;
                    b = b / 2 + b % 2;
                }
                answer++;
            }    
        }
        
        return answer;
    }
}