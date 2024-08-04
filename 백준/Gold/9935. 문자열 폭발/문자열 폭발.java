import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    class Node {
	    	char res;
	    	int idx;

	        public Node(char res, int idx) {
	            this.res = res;
	            this.idx = idx;
	        }
	    }
	    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		String check = br.readLine();
		
		Deque<Character> dq = new ArrayDeque<Character>();
		Deque<Node> tmp = new ArrayDeque<Node>();

		for (int i = 0, j = 0; i < str.length(); i++) {
			if (str.charAt(i) == check.charAt(j)) {
				tmp.addLast(new Node(check.charAt(j), j));
				j++;
			} else if (str.charAt(i) == check.charAt(0)) {
				tmp.addLast(new Node(check.charAt(0), 0));
				j = 1;
			} else {
				while(!tmp.isEmpty()) dq.add(tmp.pollFirst().res);
				dq.add(str.charAt(i));
				tmp.clear();
				j = 0;
			}
			
			if (j == check.length()) {
				for (int k = 0; k < check.length(); k++) {
					tmp.pollLast();
				}
				if (!tmp.isEmpty()) j = tmp.peekLast().idx + 1;
				else j = 0;
			}
		}
		
		while(!tmp.isEmpty()) dq.add(tmp.pollFirst().res);
	
		for (char c : dq) sb.append(c);
		
		if (dq.isEmpty()) System.out.println("FRULA");
		else System.out.println(sb.toString());

	}
}
