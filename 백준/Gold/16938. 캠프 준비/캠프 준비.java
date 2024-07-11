import java.io.*;
import java.util.*;

public class Main {
    public static int N, L, R, X;
    public static int[] arr = new int[15];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // N개 문제
		L = Integer.parseInt(st.nextToken()); // 크거나 같고
		R = Integer.parseInt(st.nextToken()); // 작거나 같다
		X = Integer.parseInt(st.nextToken()); // 문제의 난이도 차이 크거나 같다
		int cnt = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

        for (int i = 0; i < N; i++)
        	cnt += Back(arr[i], i+1, arr[i], arr[i]);
        System.out.println(cnt);
    }

    public static int Back(int sum, int index, int min, int max) {
        int cnt = 0;
        max = Integer.max(arr[index-1], max);
        min = Integer.min(arr[index-1], min);

        if (L <= sum && X <= max-min) {
        	cnt += 1;
        }
        if (index == N) {
        	return cnt;
        }

        for (int i = index; i < N; i++) {
            if (sum + arr[i] <= R) {
            	cnt += Back(sum + arr[i], i + 1, min, max);
            }
        }
        return cnt;
    }
}