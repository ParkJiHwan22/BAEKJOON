import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		int N = Integer.parseInt(br.readLine());
		int[] weight = new int[N];
		int total = 0;
		
		for (int i = 0; i < N; i++) {
			weight[i] = Integer.parseInt(br.readLine());
			total += weight[i];
		}
		
		boolean[][] dp = new boolean[((N+1)/2) + 1][total+1];
		dp[0][0] = true;
		
		for (int w : weight) {
			for (int i = ((N+1)/2) - 1; i >= 0; i--) {
				for (int j = 0; j < total + 1 - w; j++) {
					if(dp[i][j]) dp[i+1][j+w] = dp[i][j];
				}
			}
		}
		
		// 짝수
		if (N % 2 == 0) {
			int start = total / 2;
			int p = 0;
			
			while(!dp[N/2][start]) {
				p++;
				if (p % 2 == 1) start += p;
				else start -= p;
			}
			
			System.out.println(Math.min(start, total - start) + " " + Math.max(start, total - start));
		}
		
		// 홀수
		if (N % 2 == 1) {
			int start = total / 2;
			int p = 0;
			
			while(!dp[N/2][start] && !dp[(N+1)/2][start]) {
				p++;
				if (p % 2 == 1) start += p;
				else start -= p;
			}
			
			System.out.println(Math.min(start, total - start) + " " + Math.max(start, total - start));
		}
	}
}