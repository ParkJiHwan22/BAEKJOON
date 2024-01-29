import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;
        int cnt = 0;

        while (left < right) {
            if (m > arr[left] + arr[right]) {
                left ++;
            } else if (m < arr[left] + arr[right]) {
                right --;
            } else {
                cnt ++;
                left ++;
                right --;
            }
        }
        System.out.println(cnt);
    }
}