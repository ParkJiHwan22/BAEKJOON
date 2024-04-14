import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int maxNum = 0;

        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            maxNum = Math.max(maxNum, arr[i]);
        }

        long low = 1;
        long high = maxNum;

        while(low <= high) {
            long mid = (low + high) / 2;
            long cnt = 0;

            for(int i = 0; i < N; i++) {
                cnt += arr[i] / mid;
            }

            if(cnt >= k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(high);
    }
}