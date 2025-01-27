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
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> Integer.compare(b, a));

		
		for(int i = 0; i < N+1; i++) {
			// 기름이 모자를 때
			int move = arr.get(i)[0] - pos;
			if (oil < move) {
				while(oil < move) {
					if (!pq.isEmpty()) {
						oil += pq.poll();
						ans ++;
					} else {
						System.out.println(-1);
						return;
					}
				}
			}
			
			pq.add(arr.get(i)[1]);
			oil -= move;
			pos = arr.get(i)[0];
		}
		
		System.out.println(ans);
	}
}
