import java.util.*;

class Solution {
   public int[] solution(long[] numbers) {
       int[] answer = new int[numbers.length];
       int pos = 0;
       
       for (Long num : numbers) {
           String binary = Long.toBinaryString(num);            
           int bn = binary.length();
           
           if (bn == 1) {
               binary = "0" + binary;
           } else if (bn <= 3) {
               for (int i = 0; i < 4 - bn; i++) {
                   binary = "0" + binary;
               }                 
           } else if (bn <= 7) {
               for (int i = 0; i < 8 - bn; i++) {
                   binary = "0" + binary;
               } 
           } else if (bn <= 15) {
               for (int i = 0; i < 16 - bn; i++) {
                   binary = "0" + binary;
               } 
           } else if (bn <= 31) {
               for (int i = 0; i < 32 - bn; i++) {
                   binary = "0" + binary;
               } 
           } else if (bn <= 63) {
               for (int i = 0; i < 64 - bn; i++) {
                   binary = "0" + binary;
               }
           }
           
           int answerTrue = 1;
           boolean[] isTrue = new boolean[binary.length()];
           boolean[] visited = new boolean[binary.length()];
           int n = binary.length() / 2;
           Arrays.fill(isTrue, true);
                      
           while (true) {           
               if (n < 1) {
                   answer[pos++] = answerTrue;
                   break;
               }
               
               for (int i = 1; i < binary.length(); i++) {
                   if (i % n == 0 && !visited[i]) {
                       visited[i] = true;
                       if (binary.charAt(i) - '0' == 1 && !isTrue[i]) {
                           answerTrue = 0;
                           n = 0;
                           break; 
                       }
                       if (binary.charAt(i) - '0' == 0) {
                           for (int j = i - n + 1; j < i + n; j++) {
                               isTrue[j] = false;
                           }
                       }
                   }
               }
               
               n /= 2;
           }
       }
       
       return answer;
   }
}