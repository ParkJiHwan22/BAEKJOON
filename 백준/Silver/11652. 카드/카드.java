import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long ans = 0;
        int maxNum = 0;

        TreeMap<Long, Integer> treeMap = new TreeMap<Long, Integer>();

        for (int i = 0; i < N; i++) {
            long k = Long.parseLong(br.readLine());
            if (treeMap.containsKey(k)) {
                treeMap.put(k, treeMap.get(k) + 1);
            } else {
                treeMap.put(k, 1);
            }
        }

        for (Map.Entry<Long, Integer> entry : treeMap.entrySet()) {
            Long key = entry.getKey();
            Integer value = entry.getValue();

            if (maxNum < value) {
                maxNum = value;
                ans = key;
            }
        }

        System.out.println(ans);
    }
}