import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int minInt = Integer.MAX_VALUE;
    private static int[] population;
    private static ArrayList<ArrayList<Integer>> relation;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        population = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        // 관계를 나타내는 ArrayList
        relation = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            relation.add(new ArrayList<Integer>());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());

            for (int j = 0; j < p; j++) {
                relation.get(i).add(Integer.valueOf(st.nextToken()));
            }
        }

        boolean[] visited = new boolean[N];

        for (int i = 1; i < N; i++) {
            combinations(visited, 0, 0, i);
        }
        if (minInt == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(minInt);
    }

    public static void combinations(boolean[] visited, int start, int s, int r) {
        if (s == r) {
            division(visited, r);
        } else {
            for (int i = start; i < N; i++) {
                visited[i] = true;
                combinations(visited, i + 1, s + 1, r);
                visited[i] = false;
            }
        }
    }

    public static void division(boolean[] visited, int r) {
        int[] arrTrue = new int[r];
        int[] arrFalse = new int[N-r];

        int cnt = 0;
        boolean isErr = false;
        for (int i = 0; i < N; i++) {
            if (visited[i]) arrTrue[cnt++] = i + 1;
            else arrFalse[i - cnt] = i + 1;
        }

        // True 부분
        
        boolean[] visitedTrue = new boolean[N+1];
        LinkedList<Integer> queue = new LinkedList<>();
        visitedTrue[arrTrue[0]] = true;
        queue.add(arrTrue[0]);
        
        int cntTrue = 1;
        while (!queue.isEmpty()) {
            int num = queue.pop();

            for (int i = 0; i < relation.get(num).size(); i++) {
                for (int rn : relation.get(num)) { // 이어져있는 숫자 중에
                    for (int an : arrTrue) {
                        if (rn == an && !visitedTrue[rn]) { // arrTrue에 포함되고 방문하지 않았다면
                            visitedTrue[rn] = true;
                            cntTrue ++;
                            queue.add(rn);
                        }
                    }
                }
            }
        }
        if (cntTrue != r) isErr = true;
        
        // False 부분
        
        boolean[] visitedFalse = new boolean[N+1];
        LinkedList<Integer> queue_2 = new LinkedList<>();
        visitedFalse[arrFalse[0]] = true;
        queue_2.add(arrFalse[0]);
        
        int cntFalse = 1;
        while (!queue_2.isEmpty()) {
            int num = queue_2.pop();

            for (int i = 0; i < relation.get(num).size(); i++) {
                for (int rn : relation.get(num)) { // 이어져있는 숫자 중에
                	for (int an : arrFalse) {
                        if (rn == an && !visitedFalse[rn]) { // arrTrue에 포함되고 방문하지 않았다면
                        	visitedFalse[rn] = true;
                        	cntFalse ++;
                        	queue_2.add(rn);
                        }
                    }
                }
            }
        }

        if (cntFalse != N - r) isErr = true;
        
        int pSum = 0;
        if (!isErr) {
        	for (int t : arrTrue) {
        		pSum += population[t-1];
        	}
        	for (int f : arrFalse) {
        		pSum -= population[f-1];
        	}
            if (Math.abs(pSum) < minInt) { 
            	minInt = Math.abs(pSum);
            }
        }
    }
}