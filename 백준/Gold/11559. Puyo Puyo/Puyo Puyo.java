import java.io.*;
import java.util.*;

public class Main {
	private static boolean[][] visited;
	private static int[][] arrTmp;
	private static int[] dy = new int[]{1, 0, -1, 0};
	private static int[] dx = new int[]{0, 1, 0, -1};
	private static int puyoCnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] arr = new int[12][6];
		int cnt = 0; //  몇연쇄
		
		for (int i = 0; i < 12; i++) {
			String str = br.readLine();
			 for (int j = 0; j < 6; j++) {
				 arr[11 - i][j] = str.charAt(j) - '.';
			 }
		}
		
		arrTmp = new int[12][6]; // 1.복사해서 배열을 따로 둔다.
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				arrTmp[i][j] = arr[i][j];
			}
		}
		
		boolean isClean = true;	// 2. 터지지 않으면 멈추도록 설계
		while (isClean) {
			isClean = false;
            
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					arr[i][j] = arrTmp[i][j];
				}
			}
			arrTmp = new int[12][6];

			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 12; j++) {
					if (arr[j][i] != 0) {
						for (int k = 0; k < 12; k++) {
							if (arrTmp[k][i] == 0) {
								arrTmp[k][i] = arr[j][i];
								break;
							}
						}
					}
				}
			}

			for (int i = 0; i < 12; i++) { // 2. 배열에 숫자가 있을 경우 bfs를 돌린다.
				for (int j = 0; j < 6; j++) {
					if (arrTmp[i][j] != 0) {
						visited = new boolean[12][6];
						puyoCnt = 0;
						bfs(i, j);

						if (puyoCnt >= 4) {
							clean();	// 뿌요뿌요 지우기
							if (!isClean) {
								isClean = true;
								cnt ++;
							}
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}
	
	public static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{i, j});
		
		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			
			for (int dir = 0; dir < 4; dir++) {
				int ny = tmp[0] + dy[dir];
				int nx = tmp[1] + dx[dir];
				
				if (ny >= 0 && ny < 12 && nx >= 0 && nx < 6 && arrTmp[tmp[0]][tmp[1]] == arrTmp[ny][nx] && !visited[ny][nx]) {
					visited[ny][nx] = true;
					puyoCnt ++;
					queue.add(new int[]{ny, nx});
				}
			}
		}
	}
	
	public static void clean() {
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				if (visited[i][j]) arrTmp[i][j] = 0;
			}
		}
	}
}