import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int start = 1, end = 1, total = start, cnt = 1;
        while (end < n) {
            if (total < n) {
                end ++;
                total += end;

            } else if (total > n) {
                total -= start;
                start ++;

            } else {
                cnt ++;
                end ++;
                total += end;
            }
        }
        System.out.println(cnt);
    }
}