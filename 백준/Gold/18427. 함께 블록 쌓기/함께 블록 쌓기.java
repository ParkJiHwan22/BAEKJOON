import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[] dp = new int[H+1];
		dp[0] = 1;
		
		for (int tc = 0; tc < N; tc++) {
			st = new StringTokenizer(br.readLine());
			List<Integer> lst = new ArrayList<>();
			while(st.hasMoreTokens()) {
				lst.add(Integer.parseInt(st.nextToken()));
			}
			
			int[] tmp = new int[H+1];
			
			for (int i = 0; i < lst.size(); i++) {
				int k = lst.get(i);
				
				for (int j = k; j <= H; j++) {
					tmp[j] += dp[j - k];
				}
			}
			
			for (int j = 0; j <= H; j++) {
				dp[j] += tmp[j];
				dp[j] %= 10007;
			}			
		}
		System.out.println(dp[H]);
	}
}
