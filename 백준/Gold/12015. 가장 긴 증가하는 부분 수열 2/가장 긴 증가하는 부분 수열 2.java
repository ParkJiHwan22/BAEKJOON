import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		int mNum = 1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());		dp[0] = arr[0];

		dp[0] = arr[0];
		for (int i = 1; i < N; i++) {
			int start = 0;
			int end = mNum;
			int mid = (start + end) / 2;
			
			while (start != end) {
				mid = (start + end) / 2;
				
				if (dp[mid] < arr[i]) {
					start = mid + 1;
		
				} else if (dp[mid] >= arr[i]) {
					end = mid;
					
				}
			}

			if (dp[start] == 0) {
				dp[start] = arr[i];
				mNum++;
			} else if (arr[i] < dp[start] ) {
				dp[start] = arr[i];
			}
			
		}
		System.out.println(mNum);
	}
}
