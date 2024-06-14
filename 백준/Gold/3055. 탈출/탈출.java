import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[] dy = new int[]{0, 1, 0, -1};
		int[] dx = new int[]{1, 0, -1, 0};
		
		int[][] arr = new int[R][C];
		int[] start = new int[2];
		int[] end = new int[2];
		
		for (int i = 0; i < R; i++) {
			String str = new String(br.readLine());
			
			for (int j = 0; j < C; j++) {
				if (str.charAt(j) == '*') arr[i][j] = -1;
				else if (str.charAt(j) == 'X') arr[i][j] = 10000;
				else if (str.charAt(j) == 'S') {
					arr[i][j] = 10000;
					start[0] = i;
					start[1] = j;
				}
				else if (str.charAt(j) == 'D') {
					arr[i][j] = 10000;
					end[0] = i;
					end[1] = j;
				}
			}
		}
		
		LinkedList<int[]> queue = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] == -1) queue.add(new int[]{i, j});
			}
		}
		
		// 1. 물이 넘치는 경우
		while(!queue.isEmpty()) {
			int[] tmp = queue.pop();
			int y = tmp[0];
			int x = tmp[1];
			
			for (int dir = 0; dir < 4; dir++) {
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				
				if (ny >= 0 && ny < R && nx >= 0 && nx < C && arr[ny][nx] == 0) {
					arr[ny][nx] = arr[y][x] - 1;
					queue.add(new int[]{ny, nx});
				}
				
			}
		}
		
		// 2. 길 찾기
		LinkedList<int[]> queue_2 = new LinkedList<>();
		queue_2.add(new int[]{start[0], start[1]});
		arr[start[0]][start[1]] = 1;
		
		boolean iserr = false;
		while(!queue_2.isEmpty()) {
			int[] tmp = queue_2.pop();
			int y = tmp[0];
			int x = tmp[1];
			
			for (int dir = 0; dir < 4; dir++) {
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				
				if (ny >= 0 && ny < R && nx >= 0 && nx < C ) {
					if ((arr[ny][nx] == 0) || (arr[ny][nx] < 0 && arr[y][x] + 1 < Math.abs(arr[ny][nx]))) {
						arr[ny][nx] = arr[y][x] + 1;
						queue_2.add(new int[]{ny, nx});
					}
					
					if (ny == end[0] && nx == end[1]) {
						arr[end[0]][end[1]] = arr[y][x];
						iserr = true;
						break;
					}
				}

			}
			
			if (iserr) break;
		}		
		if (!iserr) System.out.println("KAKTUS");
		else System.out.println(arr[end[0]][end[1]]);
	}
}