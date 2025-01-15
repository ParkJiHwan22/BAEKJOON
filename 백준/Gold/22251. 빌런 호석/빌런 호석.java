import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());	// 1~P 개 바꿀 수 있음
        String X = "000000" + st.nextToken();	// X층에 멈춰있을 때
        
        String[] str = {"1111110", "0110000", "1101101", "1111001", "0110011", "1011011", "1011111", "1110000", "1111111", "1111011"};
        
        int[][] idx = new int[10][10];
        
        for (int i = 0; i < 10; i++) {
        	for (int j = 0; j < 10; j++) {
        		int cnt = 0;
        		for (int k = 0; k < 7; k++) {
        			if (str[i].charAt(k) != str[j].charAt(k)) {
        				cnt ++;
        			}
        		}
        		idx[i][j] = cnt; 
        	}
        }
        
        // s와 P를 비교하여 숫자가 몇개나 바뀌는지 확인
        for (int i = 1; i <= N; i++) {
        	String s = "000000" + i;
        	int tmp = 0;
        	
        	for (int j = 1; j <= K; j++) {
        		tmp += idx[s.charAt(s.length() - j) - '0'][X.charAt(X.length() - j) - '0'];
        	}

        	if (tmp <= P && tmp != 0) {
        		answer++;
        	}
        }
        
        
        System.out.println(answer);
	}
}