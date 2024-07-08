import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader와 BufferedWriter를 사용하여 입력과 출력을 최적화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cul = new int[N + 1];

        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(st.nextToken());
            cul[i + 1] = cul[i] + k;
        }
        
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            // BufferedWriter를 사용하여 출력
            bw.write((cul[b] - cul[a - 1]) + "\n");
        }
        
        // BufferedWriter를 닫아 출력 내용을 최종적으로 flush
        bw.flush();
        bw.close();
    }
}