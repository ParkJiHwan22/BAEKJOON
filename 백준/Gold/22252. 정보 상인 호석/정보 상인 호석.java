import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        HashMap<String, PriorityQueue<Integer>> hm = new HashMap<>();
        long res = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            int cnt = Integer.parseInt(st.nextToken());

            if (k == 1) {
                for (int j = 0; j < cnt; j++) {
                    if (!hm.containsKey(str)) {
                        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                        pq.add(Integer.parseInt(st.nextToken()));
                        hm.put(str, pq);
                    } else {
                        hm.get(str).add(Integer.parseInt(st.nextToken()));
                    }
                }
            } else {
                if (!hm.containsKey(str) || hm.get(str) == null) continue;
                PriorityQueue<Integer> pq = hm.get(str);
                while (!pq.isEmpty() && cnt > 0) {
                    res += pq.poll();
                    cnt--;
                }
            }
        }

        System.out.println(res);
    }
}