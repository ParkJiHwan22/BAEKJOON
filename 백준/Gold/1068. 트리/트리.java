import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arr.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr.get(i).add(i);
            int num = Integer.parseInt(st.nextToken());
            if (num >= 0) arr.get(num).add(i);
        }

        int t = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        q.add(t);

        while (!q.isEmpty()) {
            int tmp = q.poll();

            // 위쪽에 대한 처리
            for (int i = 0; i < tmp; i++) {
                for (int j = 0; j < arr.get(i).size(); j++) {
                    if (arr.get(i).get(j) == tmp) {
                        arr.get(i).remove(j);
                    }
                }
            }


            // 아래쪽에 대한 처리
            for (int arrNum : arr.get(tmp)) {
                q.add(arrNum);
            }
            arr.get(tmp).clear();
        }

        for (int i = 0; i < N; i++) {
            if (arr.get(i).size() == 1) cnt++;
        }

        System.out.println(cnt);
    }
}
