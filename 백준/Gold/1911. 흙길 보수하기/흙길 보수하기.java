import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int pos = 0;
        int ans = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pq.offer(new int[]{start, end});
        }

        while (!pq.isEmpty()) {
            int[] s = pq.poll();
            int start = s[0];
            int end = s[1];

            if (end < pos) continue;
            else {
                int p = end - Math.max(start, pos);
                if (p % L == 0) {
                    ans += p / L;
                    pos = end + 1;
                }
                else {
                    ans += (p / L) + 1;
                    pos = Math.max(start, pos) + (p / L) * L + L;
                }
            }
        }

        System.out.println(ans);
    }
}