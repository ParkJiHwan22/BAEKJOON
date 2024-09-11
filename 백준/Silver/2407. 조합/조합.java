import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BigInteger num = BigInteger.valueOf(1);

        for (int i = 1; i < m + 1; i++) {
            num = num.multiply(BigInteger.valueOf(n - i + 1));
            num = num.divide(BigInteger.valueOf(i));
        }

        System.out.println(num);
    }
}