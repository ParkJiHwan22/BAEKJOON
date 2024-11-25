import java.util.*;
import java.io.*;

public class Main {
    private static List<List<Integer>> graph;
    private static int[] colors;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < K; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();
            colors = new int[V+1];

            for(int v = 0 ; v <= V; v++) {
                graph.add(new ArrayList<>());
            }

            for(int e = 0; e < E; e++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph.get(from).add(to);
                graph.get(to).add(from); // 양방향 모두 연결
            }

            boolean isTrue = false;
            for(int v = 1; v <= V; v++) {
                if(colors[v] == 0) {
                    isTrue = mainGraph(v, 1);
                }
                if(!isTrue) break;
            }
            if(isTrue) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static boolean mainGraph(int start, int color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        colors[start] = color;

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int next : graph.get(cur)) {
                if(colors[cur] == colors[next]) return false; // 색깔이 같을 경우 false 반환
                if(colors[next] == 0) { // 색깔이 없을 경우 색깔의 반대 색깔을 제공
                    colors[next] = colors[cur] * -1;
                    queue.add(next);
                }
            }
        }
        return true;
    }
}
