import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuffer sb = new StringBuffer();

        // Integer형 스택 선언
        Stack<Integer> stackInt = new Stack<>();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine()); // 한 줄의 입력을 읽고 토큰으로 분리
            int A = Integer.parseInt(st.nextToken()); // 첫 번째 토큰은 첫 번째 숫자
            if (A == 1) {
                int B = Integer.parseInt(st.nextToken()); // 두 번째 토큰은 두 번째 숫자
                stackInt.push(B);
            } else if (A == 2) {
                if (stackInt.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(stackInt.pop()).append("\n");
                }
            } else if (A == 3) {
                sb.append(stackInt.size()).append("\n");
            } else if (A == 4) {
                if (stackInt.isEmpty()) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            } else if (A == 5) {
                if (stackInt.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(stackInt.peek()).append("\n");
                }
            }
        }

        System.out.print(sb.toString()); // 모든 출력을 한 번에 출력
    }
}