import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int answer = 0;

        // N+1 크기의 배열 생성
        isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true); // 처음에는 모든 수가 소수(true)인 것으로 설정
        isPrime[0] = isPrime[1] = false; // 0과 1은 소수가 아님

        // 에라토스테네스의 체 알고리즘 수행
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                // i가 소수라면, i의 배수들을 모두 체크
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int start = 2;
        int end = 3;

        int total = start + end;

        while (end < N) {
            if (N == total) {
                answer ++;
                total -= start;
                start = nextNumber(start);
                end = nextNumber(end);
                total += end;
            } else if (N < total) {
                total -= start;
                start = nextNumber(start);
            } else {
                end = nextNumber(end);
                total += end;
            }
        }

        if (isPrime[N]) answer++;

        System.out.println(answer);
    }

    public static int nextNumber(int k) {
        for (int i = k + 1; i <= N; i++) {
            if (isPrime[i]) {
                return i;
            }
        }

        return N;
    }
}