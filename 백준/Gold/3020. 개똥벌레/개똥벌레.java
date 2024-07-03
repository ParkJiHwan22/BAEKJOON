import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] odd = new int[H+1];
        int[] even = new int[H+1];

        // 입력
        for (int c = 1; c < N+1; c++) {
            int curr = Integer.parseInt(br.readLine());
            if(c % 2 != 0) odd[curr] += 1;
            else even[curr] += 1;
        }
        
        // 누적합
        for (int i = 1; i < H+1; i++) {
            odd[i] = odd[i-1] + odd[i];
            even[i] = even[i-1] + even[i];
        }

        int res = 0;

        int[] list = new int[H+1];
        int min = Integer.MAX_VALUE;

        // 아이디어
        for (int i = 1; i < H+1; i++) {
            list[i] += odd[H] - odd[i-1];
            list[i] += even[H] - even[H-i];
            min = Math.min(min, list[i]);
        }
        
        for (int i = 1; i < H+1; i++) {
            if(list[i] == min) res++;
        }

        System.out.println(min + " " + res);
    }
}