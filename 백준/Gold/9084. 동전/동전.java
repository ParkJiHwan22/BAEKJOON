import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t =0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			List<Integer> lst = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				lst.add(Integer.parseInt(st.nextToken()));
			}
			
			int M = Integer.parseInt(br.readLine());
			
			int[] dp = new int[M+1];
			dp[0] = 1;
			
			for (int l = 0; l < lst.size(); l++) {
				int k = lst.get(l);
				
				for (int i = k; i <= M; i ++) {
					dp[i] += dp[i - k];
				}
			}
			
			System.out.println(dp[M]);
		}
	}
}
