import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt((br.readLine()));
		PriorityQueue<Integer> pqm = new PriorityQueue<Integer>();
		PriorityQueue<Integer> pqp = new PriorityQueue<Integer>();
		PriorityQueue<Integer> res = new PriorityQueue<Integer>();
		int minNum = Integer.MAX_VALUE;
		
		boolean isN = false;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (n > 0) pqp.add(n);
			else if (n == 0) isN = true;
			else pqm.add(-n);
		}
		
		if (pqm.isEmpty()) {
			res.add(pqp.poll());
			res.add(pqp.poll());
		} else if (pqp.isEmpty()) {
            res.add(-pqm.poll());
            res.add(-pqm.poll());
		} else {
			if (pqp.size() >= 2) {
				int p1 = pqp.poll();
				int p2 = pqp.poll();
				if (minNum >= p1 + p2) {
					minNum = p1 + p2;
					res.add(p1);
					res.add(p2);
				}
				pqp.add(p1);
				pqp.add(p2);
			}
			if (pqm.size() >= 2) {
				int m1 = pqm.poll();
				int m2 = pqm.poll();
				if (minNum >= m1 + m2) {
					minNum = m1 + m2;
					res.add(-m1);
					res.add(-m2);
				}
				pqm.add(m1);
				pqm.add(m2);
			}
			if (isN) {
				if (pqp.peek() >= pqm.peek()) {
                    res.add(-pqm.peek());
                    res.add(0);
					minNum = pqm.peek();
				} else {
                    res.add(pqp.peek());
                    res.add(0);
					minNum = pqp.peek();
				}
			}
			while (!pqm.isEmpty() && !pqp.isEmpty()) {
				if (pqp.peek() == pqm.peek()) {
					res.clear();
					res.add(-(pqm.poll()));
					res.add(pqp.poll());
					break;
				} else if (pqp.peek()- pqm.peek() > 0) {
					if (minNum > pqp.peek() - pqm.peek()) {
						res.clear();
						res.add(-pqm.peek());
						res.add(pqp.peek());
						minNum = pqp.peek() - pqm.peek();
					}
					pqm.poll();
				} else {
					if (minNum > pqm.peek() - pqp.peek()) {
						res.clear();
						res.add(-pqm.peek());
						res.add(pqp.peek());
						minNum = pqm.peek() - pqp.peek();
					}
					pqp.poll();
				}
			}
		}
		System.out.println(res.poll() + " " + res.poll());
	}
}