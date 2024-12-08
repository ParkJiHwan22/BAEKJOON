import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String L = st.nextToken();
		String R = st.nextToken();
		int ans = 0;
		
		if (L.length() == R.length()) {
			for(int i = 0; i < L.length(); i++) {
				if (L.charAt(i) == '8' && R.charAt(i) == '8') ans++;
				else if (L.charAt(i) == R.charAt(i)) continue;
				else break;
			}
		}
		
		System.out.println(ans);
	}
}
