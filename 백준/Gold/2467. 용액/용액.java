import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> minus = new Stack<>();
		Deque<Integer> plus = new LinkedList<>();
		
		int [] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int minNum = Integer.MAX_VALUE; 
		int[] ans = {0, 0};
		
		int s = 0;
		int e = N - 1;
		while (s < e) {
			if (minNum > Math.abs(arr[s] + arr[e])) {
				minNum = Math.abs(arr[s] + arr[e]);
				ans[0] = arr[s];
				ans[1] = arr[e];
			}
			
			if (arr[s] <= 0 && arr[e] <= 0) s++;
			else if (arr[s] > 0 && arr[e] > 0) e--;
			else if (arr[s] + arr[e] < 0) s ++;
			else e --;

		}  
		
		if (ans[0] <= ans[1]) System.out.println(ans[0] + " " + ans[1]);
		else System.out.println(ans[1] + " " + ans[0]);
	}
}