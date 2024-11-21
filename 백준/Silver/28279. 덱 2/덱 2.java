import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Deque<Integer> dq = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int x = Integer.parseInt(st.nextToken());
                dq.addFirst(x);
            }
            if (cmd == 2) {
                int x = Integer.parseInt(st.nextToken());
                dq.addLast(x);
            }
            if (cmd == 3) {
                if (!dq.isEmpty()) {
                    sb.append(dq.pollFirst()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            }
            if (cmd == 4) {
                if (!dq.isEmpty()) {
                    sb.append(dq.pollLast()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            }
            if (cmd == 5) {
                sb.append(dq.size()).append("\n");
            }
            if (cmd == 6) {
                if (!dq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(1).append("\n");
                }
            }
            if (cmd == 7) {
                if (!dq.isEmpty()) {
                    sb.append(dq.peekFirst()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            }
            if (cmd == 8) {
                if (!dq.isEmpty()) {
                    sb.append(dq.peekLast()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}