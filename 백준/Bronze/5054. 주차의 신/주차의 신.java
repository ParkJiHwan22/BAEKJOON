import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) { // Corrected loop increment
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int maxInt = 0;
            int minInt = 100;

            for (int k = 0; k < n; k++) { // Corrected loop condition and increment
                if (maxInt < arr[k]) {
                    maxInt = arr[k];
                }
                if (minInt > arr[k]) {
                    minInt = arr[k];
                }
            }
            sb.append((maxInt - minInt) * 2 + "\n");
        }
        System.out.print(sb.toString());
    }
}