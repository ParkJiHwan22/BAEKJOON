import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int node, cost;
        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    static int N, M;
    static List<Edge>[] graph;
    static int[] dist;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        dist = new int[N + 1];
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        dijkstra(1);

        List<int[]> result = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            result.add(new int[]{parent[i], i});
        }

        System.out.println(result.size());
        for (int[] edge : result) {
            System.out.println(edge[0] + " " + edge[1]);
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new Edge(start, 0));
        parent[start] = -1;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentNode = current.node;

            for (Edge edge : graph[currentNode]) {
                int nextNode = edge.node;
                int nextDist = dist[currentNode] + edge.cost;

                if (nextDist < dist[nextNode]) {
                    dist[nextNode] = nextDist;
                    parent[nextNode] = currentNode;
                    pq.add(new Edge(nextNode, nextDist));
                }
            }
        }
    }
}
