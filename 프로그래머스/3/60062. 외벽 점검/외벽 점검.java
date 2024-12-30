import java.util.*;

class Solution {
   public int solution(int n, int[] weak, int[] dist) {
       int[] dp = new int[1 << weak.length];
       Arrays.fill(dp, -1);
       dp[0] = 0;
       
       Arrays.sort(dist);
       
       Queue<int[]> q = new LinkedList<>();
       q.add(new int[]{0, 0});
              
       while (!q.isEmpty()) {
           int[] tmp = q.poll();
           
           if (tmp[1] == (1 << weak.length) - 1) {
               return tmp[0];
           }
           
           if (tmp[0] >= dist.length) continue;
           
           String binary = Integer.toBinaryString(tmp[1]);
           int k = (weak.length - binary.length());
           binary = "0".repeat(k) + binary;
           
           for (int i = 0; i < weak.length; i++) {
               if (binary.charAt(i) - '0' == 0) {
                   // 시계 방향
                   String binaryCopy = binary;
                   StringBuilder sb = new StringBuilder(binaryCopy);
                   
                   int distance = dist[dist.length - tmp[0] - 1];
                   for (int j = 0; j <= distance; j++) {
                       int current = (weak[i] + j) % n;
                       for (int w = 0; w < weak.length; w++) {
                           if (weak[w] == current) {
                               sb.setCharAt(w, '1');
                           }
                       }
                   }
                   
                   int x = Integer.parseInt(sb.toString(), 2);
                   if (dp[x] == -1) {
                       dp[x] = tmp[0] + 1;
                       q.add(new int[]{tmp[0] + 1, x});
                   }
                   
                   // 반시계 방향
                   binaryCopy = binary;
                   sb = new StringBuilder(binaryCopy);
                   
                   for (int j = 0; j <= distance; j++) {
                       int current = ((weak[i] - j) % n + n) % n;
                       for (int w = 0; w < weak.length; w++) {
                           if (weak[w] == current) {
                               sb.setCharAt(w, '1');
                           }
                       }
                   }
                   
                   x = Integer.parseInt(sb.toString(), 2);
                   if (dp[x] == -1) {
                       dp[x] = tmp[0] + 1;
                       q.add(new int[]{tmp[0] + 1, x});
                   }
               }
           }
       }
       
       return -1;
   }
}