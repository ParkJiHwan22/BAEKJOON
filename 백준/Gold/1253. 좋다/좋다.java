import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int cnt = 0; // 좋은 수의 개수

        for (int i = 0; i < n; i ++) {
            int left = 0;
            int right = n - 1;

            while (left < right) {
                if (arr[i] < arr[left] + arr[right] || right == i) {
                    right--;
                } else if (arr[i] > arr[left] + arr[right] || left == i) {
                    left++;
                } else {
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);
        br.close();
    }
}