import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int res = 0;

        int[][] total = new int[26][8];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                int k = str.charAt(j) - 'A';
                total[k][str.length() - j - 1]++;
            }
        }

        int[] ans = new int[26];

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 8; j++) {
                ans[i] += (int) (Math.pow(10, j) * total[i][j]);
            }
        }
        Arrays.sort(ans);

        for (int i = 9; i >= 0; i--) {
            res += ans[i + 16] * i;
        }

        System.out.println(res);
    }
}
