import java.io.*;
import java.util.*;

public class Main {
	
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 팀원의 수
		int V = Integer.parseInt(st.nextToken()); // 장소의 수
		int E = Integer.parseInt(st.nextToken()); // 도로의 수
		
		st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken()); // KIST의 위치
		int B = Integer.parseInt(st.nextToken()); // 씨알푸드의 위치
		
		
		// 팀원들의 집의 위치
		int[] teamMate = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			teamMate[i] = Integer.parseInt(st.nextToken());
		}
		
		// 집 간의 거리
		List<int[]>[] graph = new ArrayList[V + 1];		
		for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
		}

		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
            graph[a].add(new int[]{b, l});
            graph[b].add(new int[]{a, l});
		}
		
		// 기관으로부터의 거리
        int[] distFromKist = dijkstra(A, V, graph);
        int[] distFromCr = dijkstra(B, V, graph);
		
        int totalDistance = 0;

        for (int home : teamMate) {
            int distKist = distFromKist[home];
            int distCr = distFromCr[home];

            if (distKist == INF && distCr == INF) {
                totalDistance += -2;
            } else if (distKist == INF) {
                totalDistance += distCr - 1;
            } else if (distCr == INF) {
                totalDistance += distKist - 1;
            } else {
                totalDistance += distKist + distCr;
            }
        }

        System.out.println(totalDistance);
    }
	
    public static int[] dijkstra(int start, int V, List<int[]>[] graph) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();            
            int u = current[0];
            int currentDist = current[1];

            if (currentDist > dist[u]) continue;

            for (int[] neighbor : graph[u]) {
                int v = neighbor[0];
                int weight = neighbor[1];
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }
                
        return dist;
    }
}