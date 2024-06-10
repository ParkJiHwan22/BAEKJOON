import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] dimensions = br.readLine().split(" ");
        int n = Integer.parseInt(dimensions[0]);
        int m = Integer.parseInt(dimensions[1]);

        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(row[j]);
            }
        }

        dimensions = br.readLine().split(" ");
        m = Integer.parseInt(dimensions[0]);
        int k = Integer.parseInt(dimensions[1]);

        int[][] b = new int[m][k];
        for (int i = 0; i < m; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < k; j++) {
                b[i][j] = Integer.parseInt(row[j]);
            }
        }

        int[][] r = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                for (int l = 0; l < m; l++) {
                    r[i][j] += a[i][l] * b[l][j];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                sb.append(r[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}