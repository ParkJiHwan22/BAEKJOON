import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		int[] inDegree = new int[N+1];
		Arrays.fill(inDegree, 0); // 1. 0으로 진입 차수 리셋
		
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
        	arr.add(new ArrayList<Integer>());
        }

		int[][] cmd = new int[M][2]; // 2. 진입 차수, 진출 차수 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr.get(start).add(end);
			inDegree[end] ++; // 3. 진입 차수 ++
		}
		
		boolean[] visited = new boolean[N+1];
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i = 1; i < N + 1; i++) {
			if (inDegree[i] == 0 && !visited[i]) { // 4. 진입 차수가 0이고, 방문하지 않았을 때
				visited[i] = true;
				queue.add(i);
				sb.append(i).append(" ");
			}
		}
		
		while(!queue.isEmpty()) {
			int q = queue.poll();
			
			for (int num : arr.get(q)) {
				inDegree[num] --;
				if (inDegree[num] == 0 && !visited[num]) {
					visited[num] = true;
					queue.add(num);
					sb.append(num).append(" ");
				}
			}
			
		}
		
		System.out.println(sb);
	}
}
