import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());
        
        int res = 0;
        int res2 = 0;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	int k = Integer.parseInt(st.nextToken());
        	res = Math.max(res, k);
        }
        
        st = new StringTokenizer(br.readLine());
    	for (int j = 0; j < M; j++) {
    		int k = Integer.parseInt(st.nextToken());
    		res2 = Math.max(res2, k);
    	}
    	
    	System.out.println(res + res2);
    }
}