import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
		int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
		
		Stack<int[]> stack = new Stack<>(); // 정보 저장
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			stack.add(new int[]{r-1, c-1, m, s, d}); // y좌표, x좌표, 질량, 속력, 방향 
		}
		

		for (int i = 0; i < K; i++) {
			int[][] visited = new int[N][N]; // 방문 여부 처리
            ArrayList<Integer>[][] directions = new ArrayList[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    directions[j][k] = new ArrayList<>();
                }
            }
			
            int[][][] newArr = new int[N][N][3]; // 질량, 속력, 방향 합 배열
            
			// 1. 파이어볼 이동 시킴			
			while (!stack.isEmpty()) {
				int[] tmp = stack.pop();
				int y = (tmp[0] + dy[tmp[4]] * tmp[3] % N + N) % N;
                int x = (tmp[1] + dx[tmp[4]] * tmp[3] % N + N) % N;
				newArr[y][x][0] += tmp[2];	// 질량
				newArr[y][x][1] += tmp[3];	// 속력
                directions[y][x].add(tmp[4]); // 방향 추가
                visited[y][x]++;
			}
			
			// 2개 이상의 파이어볼 처리, 다시 arr에 담음 
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (visited[j][k] >= 2 && newArr[j][k][0] / 5 > 0) {
	                    int mass = newArr[j][k][0] / 5;
	                    int speed = newArr[j][k][1] / visited[j][k];
	                    boolean even = true, odd = true; // 홀수인지, 짝수인지 판단
	                    for (int dir : directions[j][k]) {
	                        if (dir % 2 == 0) odd = false;
	                        else even = false;
	                    }
	                    int startDir = even || odd ? 0 : 1;	// 전부다 홀수이거나 짝수이면 0, 아니면 1                    
	                    for (int l = startDir; l < 8; l += 2) {
	                        stack.add(new int[]{j, k, mass, speed, l});
	                    }
	                } else if (visited[j][k] == 1) {
	                    stack.add(new int[]{j, k, newArr[j][k][0], newArr[j][k][1], directions[j][k].get(0)});
	                }
				}
			}
		}
		int resNum = 0;
		while (!stack.isEmpty()) {
			int[] res = stack.pop();
			resNum += res[2];
		}	
		
		System.out.println(resNum);

	}
}