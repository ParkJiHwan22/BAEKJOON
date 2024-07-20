import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		List<LinkedList<int[]>> lst = new LinkedList<LinkedList<int[]>>();
		for (int i = 0; i <= n; i++) {
			lst.add(new LinkedList<int[]>());
		}
		
		int[] distance = new int[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		int[] bNum = new int[n+1];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			
			lst.get(start).add(new int[]{dis, end}); // (이동 거리, 도착점)
		}
		
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		distance[S] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
		pq.add(new int[] {0, S});
		
		while (!pq.isEmpty()) {			
			int[] cur = pq.poll();

			if (cur[0] <= distance[cur[1]]) { // 시작점 누적 거리 < 시작점 누적 거리
				for (int[] tmp : lst.get(cur[1])){ // (이동 거리, 도착점)
					if (cur[0] + tmp[0] < distance[tmp[1]]) { // 시작점 누적 거리 + 이동거리 < 도착점 누적 거리
						distance[tmp[1]] = cur[0] + tmp[0]; // 도착점 누적 거리 = 시작점 누적 거리 + 이동거리
						pq.add(new int[] {distance[tmp[1]], tmp[1]}); // 도착점 누적 거리, 도착점-> 시작점이 될 것
						bNum[tmp[1]] = cur[1];
					}
				}
			}
		}
		System.out.println(distance[E]);
		
		Stack<Integer> res = new Stack<Integer>();
		while(true) {
			res.add(E);
			if (E == S) break;
			E = bNum[E];
		}
		
		System.out.println(res.size());
		while (!res.isEmpty()) {
			System.out.print(res.pop() + " ");
		}
	}
}