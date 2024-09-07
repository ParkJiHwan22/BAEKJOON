import java.util.*;
import java.io.*;
  
class Main {
 
    static long[] res = new long[3];
    static long maxNum = 3000000000L;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
 
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            arr[i] = Long.parseLong(st.nextToken());
 
        Arrays.sort(arr);
 
        for(int i = 0; i < n - 2; i++) 
            solution(arr, i);
 
        Arrays.sort(res);
        
        for(int i = 0; i < 3; i++)
            System.out.print(res[i] + " ");
    }
 
    static void solution(long[] arr, int idx) {
        int left = idx + 1;
        int right = arr.length - 1;
 
        while(left < right) {
 
            long sum = arr[left] + arr[right] + arr[idx];
            long absSum = Math.abs(sum);
 
            // 두 용액 갱신
            if(absSum < maxNum) {
            	res[0] = arr[left];
            	res[1] = arr[right];
            	res[2] = arr[idx];
            	maxNum = absSum;
            }
 
            if(sum > 0)
                right--;
            else
                left++;
        }
    }
}