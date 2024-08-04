import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		String check = br.readLine();
		Deque<Character> dq = new ArrayDeque<Character>();
		Deque<Character> tmp = new ArrayDeque<Character>();
		Deque<Integer> idx = new ArrayDeque<Integer>();

		for (int i = 0, j = 0; i < str.length(); i++) {
			// 체크 글자에 저장되어있던 마지막 글자와 연결되는 경우,
			if (str.charAt(i) == check.charAt(j)) {
				tmp.addLast(check.charAt(j));
				idx.addLast(j);
				j++;
			// 체크 글짜의 순서는 다르지만 맨 앞글자가 맞았을 경우,
			} else if (str.charAt(i) == check.charAt(0)) {
				tmp.add(check.charAt(0));
				idx.add(0);
				j = 1;
			// 체크 글짜가 틀렸을 경우,
			} else {
				while(!tmp.isEmpty()) dq.add(tmp.pollFirst());
				dq.add(str.charAt(i));
				idx.clear();
				j = 0;
			}
			
			// 체크 글짜가 모두 맞았을 경우,
			if (j == check.length()) {
				for (int k = 0; k < check.length(); k++) {
					tmp.pollLast();
					idx.pollLast();
				}
				if (!idx.isEmpty()) j = idx.peekLast() + 1;
				else j = 0;
			}
		}
		
		while(!tmp.isEmpty()) dq.add(tmp.pollFirst());
		
		for (char c : dq) sb.append(c);
		
		if (dq.isEmpty()) System.out.println("FRULA");
		else System.out.println(sb.toString());

	}
}
