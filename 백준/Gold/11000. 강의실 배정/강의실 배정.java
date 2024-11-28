import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int maxRoom = 0;
		int room = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
		    if (a[0] == b[0]) {
		        return Integer.compare(a[1], b[1]);
		    } else {
		        return Integer.compare(a[0], b[0]);
		    }
		});
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
		
			pq.add(new int[] {s, 1});
			pq.add(new int[] {e , -1});			
		}
		
		while(!pq.isEmpty()) {
			int[] tmp = pq.poll();
			 room += tmp[1];
			 maxRoom = Math.max(maxRoom, room);
		}
		
		System.out.println(maxRoom);
	}
}
