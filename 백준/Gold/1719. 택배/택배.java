import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<int[]>> arr = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        int[][] matrix = new int[n+1][n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr.get(a).add(new int[]{c, b});
            arr.get(b).add(new int[]{c, a});
        }

        for (int i = 1; i <= n; i++) {
            int[] distance = new int[n + 1];
            int[] bNum = new int[n + 1];
            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[i] = 0;

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
            pq.add(new int[]{0, i});

            while (!pq.isEmpty()) {
                int[] tmp = pq.poll();
                int totalCost = tmp[0];
                int start = tmp[1];

                if (totalCost > distance[start]) continue;

                for (int[] cur : arr.get(start)) {
                    int cost = cur[0];
                    int end = cur[1];

                    if (totalCost + cost < distance[end]) {
                        distance[end] = totalCost + cost;
                        pq.add(new int[]{distance[end], end});

                        if (start == i) bNum[end] = end;
                        else bNum[end] = bNum[start];
                    }
                }
            }


            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    matrix[i][j] = -1;
                } else {
                    matrix[i][j] = bNum[j];
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i][j] == -1) sb.append("-").append(" ");
                else  sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}