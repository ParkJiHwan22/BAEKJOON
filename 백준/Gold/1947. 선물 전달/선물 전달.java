import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[1000001];
        dp[1] = 0;
        dp[2] = 1;
        
        int mod = 1000000000;
        for (int i = 3; i < 1000001; i++) {
            dp[i] = ((i - 1) * (dp[i - 1] + dp[i - 2]) % mod) % mod;
        }
        System.out.print(dp[N]);
    }
}