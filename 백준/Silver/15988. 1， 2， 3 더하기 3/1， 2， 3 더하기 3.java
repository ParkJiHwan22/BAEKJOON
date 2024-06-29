import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long[] res = new long[1000001];
        res[1] = 1;
        res[2] = 2;
        res[3] = 4;

        for (int i = 4; i < 1000001; i++) {
            res[i] = (res[i-1] + res[i-2] + res[i-3]) % 1000000009;
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(res[N]);
        }

    }
}