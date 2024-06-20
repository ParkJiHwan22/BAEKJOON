import java.io.*;
import java.util.*;

public class Main {
	
	private static ArrayList<Integer[]> graph[];
	private	static boolean visited[];
	private	static int intMax = 0;
	private	static int findNode = 1 ;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		visited = new boolean[N+1];
		graph = new ArrayList[N+1];
		
		for(int i = 1; i < graph.length; i++) {
			graph[i]=new ArrayList<>();
		}
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph[start].add(new Integer[] {end, weight});
			graph[end].add(new Integer[] {start, weight});
		}
		
		dfs(1, 0);
		intMax = 0;
		Arrays.fill(visited, false);
		dfs(findNode, 0);
		
		System.out.println(intMax);
		
	}
	public static void dfs(int node, int sum) {
		visited[node] = true;
		if(sum > intMax) {
			intMax = sum;
			findNode = node;
		}

		for(Integer[] temp : graph[node]) {
			int next = temp[0];
			int cost = temp[1];
			if(!visited[next]){
				dfs(next, sum + cost);
			}
		}
		
	}
}
