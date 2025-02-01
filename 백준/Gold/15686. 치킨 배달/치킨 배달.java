import java.io.*;
import java.util.*;

public class Main {

    private static int N, M, K, L, res;
    private static int[][] arr;
    private static List<List<Integer>> homeDistance = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        res = Integer.MAX_VALUE;
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 치킨집 기준에서 집의 거리를 모두 저장 [1, 2, 6], [2, 3, 3], ... 이런 식으로
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 2) save(i, j);
            }
        }
        
        K = homeDistance.get(0).size();
        L = homeDistance.size();
        
        // 2. 조합을 돌린다. 예를 들면 13C6
        boolean[] visited = new boolean[L];
        combination(0, 0, visited);
        System.out.println(res);
    }

    public static void save(int i, int j) {
        List<Integer> home = new ArrayList<>();

        for (int k = 0; k < N; k++) {
            for (int l = 0; l < N; l++) {
                if (arr[k][l] == 1) {
                    home.add(Math.abs(i - k) + Math.abs(j - l));
                }
            }
        }

        homeDistance.add(home);
    }

    public static void combination(int r, int s, boolean[] visited) {
    	if (r == M) {
//    		System.out.println(Arrays.toString(visited));
    		// 3. 여기에서 해당하는 것들만 모아서 값이 얼마인지 구함
    		calculation(visited);    		
    	} else {
    		for (int i = s; i < L; i++) {
    			visited[i] = true;
    			combination(r+1, i+1, visited);
    			visited[i] = false;
    		}
    	}
    }
    
    public static void calculation(boolean[] visited) {
    	int[] tmp = new int[K];
		
    	for (int i = 0; i < L; i++) {
    		if (visited[i]) {
        		for (int j = 0; j < K; j++) {
	    			if (tmp[j] == 0 || tmp[j] > homeDistance.get(i).get(j)) {
	    				tmp[j] = homeDistance.get(i).get(j);
	    			}
	    		}
    		}
    	}
    	
    	int sum = 0;
    	for (int i = 0; i < K; i++) {
    		sum += tmp[i];
    	}
    	
    	if (res > sum) res = sum;
    }
}