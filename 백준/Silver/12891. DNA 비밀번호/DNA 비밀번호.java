import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String dna = br.readLine();

        int[] dnaList = new int[4]; // {'A', 'C', 'G', 'T'}
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            dnaList[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int[] checkList = new int[4];
        for (int j = 0; j < m; j ++) { // 한 구역씩 검사
            if (dna.charAt(j) == 'A') {
                checkList[0] ++;
            } else if (dna.charAt(j) == 'C') {
                checkList[1] ++;
            } else if (dna.charAt(j) == 'G') {
                checkList[2] ++;
            } else if (dna.charAt(j) == 'T') {
                checkList[3] ++;
            }
        }
        int err = 0;
        for (int j = 0; j < 4; j ++) {
            if (dnaList[j] > checkList[j]) {
                err ++;
                break;
            }
        }
        if (err == 0) {
            cnt ++;
        }

        for (int i = 1; i < n - m + 1; i++) {
            if (dna.charAt(i - 1) == 'A') {
                checkList[0] --;
            } else if (dna.charAt(i - 1) == 'C') {
                checkList[1] --;
            } else if (dna.charAt(i - 1) == 'G') {
                checkList[2] --;
            } else if (dna.charAt(i - 1) == 'T') {
                checkList[3]--;
            }

            if (dna.charAt(i + m - 1) == 'A') {
                checkList[0] ++;
            } else if (dna.charAt(i + m - 1) == 'C') {
                checkList[1] ++;
            } else if (dna.charAt(i + m - 1) == 'G') {
                checkList[2] ++;
            } else if (dna.charAt(i + m - 1) == 'T') {
                checkList[3] ++;
            }

            err = 0;
            for (int j = 0; j < 4; j ++) {
                if (dnaList[j] > checkList[j]) {
                    err ++;
                    break;
                }
            }
            if (err == 0) {
                cnt ++;
            }
        }
        System.out.println(cnt);
    }
}