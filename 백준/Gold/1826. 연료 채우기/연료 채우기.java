import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		List<int[]> arr = new ArrayList<int[]>();
		int ans = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			// 위치, 넣을 수 있는 연료의 양
			int p = Integer.parseInt(st.nextToken());
			int o = Integer.parseInt(st.nextToken());
			arr.add(new int[] {p, o});
		}
		
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		arr.add(new int[] {p, 0});
		
		Collections.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
		
		int pos = 0;
		int oil = Integer.parseInt(st.nextToken());
		// 주유소에서 멈추는 횟수를 최소화
		// 가다가 기름이 다 떨어지면 이제까지 지나온 길에서 가장 큰 곳을 골라냄
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for(int i = 0; i < N+1; i++) {
			// 1 지나가도 기름이 남을 때
			if (oil < (arr.get(i)[0] - pos)) {
				// 2. 지나가도 기름이 모자를 때
				while(oil < (arr.get(i)[0] - pos)) {
					if (!pq.isEmpty()) {
						int t = pq.poll();
						oil += -t;
						ans ++;
					} else {
						System.out.println(-1);
						return;
					}
				}
			}
			
			pq.add(-arr.get(i)[1]);
			oil -= arr.get(i)[0] - pos;
			pos = arr.get(i)[0];
		}
		
		System.out.println(ans);
	}
}
