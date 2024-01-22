import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arrInt = new int[n];
        int maxCnt = 0;

        for (int i = 0; i < n; i++) {
            arrInt[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arrInt);

        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 1; j < 5; j++) {
                if (i + j < n) {
                    if (arrInt[i+j] - arrInt[i] <= 4) {
                        cnt += 1;
                    } else {
                        break;
                    }
                }
            }
            if (maxCnt < cnt) {
                maxCnt = cnt;
            }
        }
        System.out.println(5 - maxCnt);
    }
}