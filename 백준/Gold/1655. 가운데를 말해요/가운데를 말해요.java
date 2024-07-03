import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pqd = new PriorityQueue<>();
        PriorityQueue<Integer> pqu = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int curr = Integer.parseInt(br.readLine());
            if (pqd.size() == 0) pqd.add(-curr);
            else if (pqu.size() <= pqd.size()) {
                if (-pqd.peek() <= curr) pqu.add(curr);
                else {
                    pqd.add(-curr);
                    pqu.add(-pqd.poll());
                }
            }
            else {
                if (pqu.peek() >= curr) pqd.add(-curr);
                else {
                    pqu.add(curr);
                    pqd.add(-pqu.poll());
                }
            }
            if (pqu.size() <= pqd.size()) System.out.println(-pqd.peek());
            else System.out.println(pqu.peek());
        }
    }
}