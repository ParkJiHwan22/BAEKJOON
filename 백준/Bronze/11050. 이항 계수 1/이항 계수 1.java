import java.io.*;
import java.util.*;

public class Main {
	
	private static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int s = N;
		int e = M;
		int res = 1;
		while (s != N - M) res *= s--;
		while (e != 0) res /= e--;

		System.out.println(res);
	}
}