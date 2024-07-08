import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] cul = new int[N+1];

		for (int i = 0; i < N; i ++) {
			int k = Integer.parseInt(st.nextToken());
			cul[i+1] += k + cul[i];
		}
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i ++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			System.out.println(cul[b] - cul[a-1]);
		}
	}
}