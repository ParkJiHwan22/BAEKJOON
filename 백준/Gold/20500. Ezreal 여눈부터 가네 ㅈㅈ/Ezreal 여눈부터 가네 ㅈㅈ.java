import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        int N = Integer.parseInt(br.readLine()); 
        long[] dp = new long[N];
        
        if (N > 1) {
            dp[1] = 1;
            for (int i = 2; i < N; i++) {
            	dp[i] = dp[i - 1] + dp[i - 2] * 2;
                if (dp[i] > 1000000007) dp[i] %= 1000000007;
            }
        }
        
        System.out.println(dp[N-1]);
	}
}