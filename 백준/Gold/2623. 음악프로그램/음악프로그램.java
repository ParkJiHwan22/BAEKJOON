import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] inDegree = new int[N + 1];	// 진입 차수
		boolean[] visited = new boolean[N + 1];	// 방문 여부 처리
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>(); // 관계 배열 저장
        for (int i = 0; i < N + 1; i++) {
            arr.add(new ArrayList<>());
        }
		
		for (int j = 0; j < M; j++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());

			int[] tmp = new int[k];
			for (int i = 0; i < k; i++) {
				tmp[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < k - 1; i++) {
				arr.get(tmp[i]).add(tmp[i+1]);
				inDegree[tmp[i+1]] ++;
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i < N + 1; i++) {
			if (inDegree[i] == 0 && !visited[i]) {
				queue.add(i);
				visited[i] = true;
				sb.append(i).append("\n");
			}
			
			while (!queue.isEmpty()) {
				int q = queue.poll();
				
				for (int num : arr.get(q)) {
					inDegree[num] --;
					if (inDegree[num] == 0 && !visited[num]) {
						queue.add(num);
						visited[num] = true;
						sb.append(num).append("\n");
					}
				}
			}
		}
				
		for (int i= 1; i < N + 1; i++) {
			if (!visited[i]) {
				System.out.println(0);
				return;
			}
		}
		
		System.out.println(sb);
	}
}
