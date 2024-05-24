import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[T+1][W+1];
		
		for (int i = 0; i < T; i++) {
			for (int j = 0; j <= W; j++) {
				dp[i][j] = -1;
			}
		}
		dp[0][0] = 0;
		
		for (int i = 0; i < T; i++) {
			int p = Integer.parseInt(br.readLine()) - 1;
			for (int j = 0; j <= W; j++) {
				if (j == W && dp[i][j] >= 0 && j % 2 == p) {
					dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + 1);
				} else if (j == W && dp[i][j] >= 0 && j % 2 != p) {
					dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
				} else if (dp[i][j] >= 0 && j % 2 == p) {
					dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + 1);
					dp[i + 1][j+1] = Math.max(dp[i + 1][j], dp[i][j]);
				} else if (dp[i][j] >= 0 && j % 2 != p) {
					dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
					dp[i + 1][j+1] = Math.max(dp[i + 1][j], dp[i][j] + 1);
				}				
			}
		}

		System.out.println(dp[T][W]);
	}
}
