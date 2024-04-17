import java.io.*;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] dp = new long[30];
        dp[0] = 1;
        dp[1] = 2;
        BigDecimal[] dpPlus = new BigDecimal[30];
        dpPlus[0] = BigDecimal.ONE;
        BigDecimal[] dpMinus = new BigDecimal[30];
        plus(dpPlus, 2, 1);
        minus(dpMinus, 2, 0);
        dpSum(dpPlus, dpMinus, dp, 2);

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            System.out.println(dp[n - 1]);
        }
    }

    public static void plus(BigDecimal[] dpPlus, int n, int m) {
        BigDecimal tmp = BigDecimal.ONE;
        for (int i = (n - 1) * 2; i > (n - 1); i--) {
            tmp = tmp.multiply(BigDecimal.valueOf(i));
            tmp = tmp.divide(BigDecimal.valueOf((n - 1) * 2 - i + 1), 15, BigDecimal.ROUND_HALF_UP);
        }
        dpPlus[m] = tmp;
        if (m < 29) {
            plus(dpPlus, n + 1, m + 1);
        }
    }

    public static void minus(BigDecimal[] dpMinus, int n, int m) {
        BigDecimal tmp = BigDecimal.ONE;
        for (int i = n; i > n - m; i--) {
            tmp = tmp.multiply(BigDecimal.valueOf(i));
            tmp = tmp.divide(BigDecimal.valueOf(n - i + 1), 15, BigDecimal.ROUND_HALF_UP);
        }
        dpMinus[m] = tmp;
        if (m < 29) {
            minus(dpMinus, n + 2, m + 1);
        }
    }

    public static void dpSum(BigDecimal[] dpPlus, BigDecimal[] dpMinus, long[] dp, int n) {
        BigDecimal tmp = dpPlus[n];
        for (int i = 0; i < n - 1; i++) {
            tmp = tmp.subtract(BigDecimal.valueOf(dp[i]).multiply(dpMinus[n - i - 2]));
        }
        dp[n] = tmp.longValue();
        if (n < 29) {
            dpSum(dpPlus, dpMinus, dp, n + 1);
        }
    }
}
