import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		int[] cul = new int[N+1];
		for (int i = 0; i < N; i ++) nums[i] = Integer.parseInt(st.nextToken());
		cul[1] = nums[0];
		for (int i = 1; i < N; i ++) cul[i+1] += nums[i] + cul[i];
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i ++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			System.out.println(cul[b] - cul[a-1]);
		}
	}
}