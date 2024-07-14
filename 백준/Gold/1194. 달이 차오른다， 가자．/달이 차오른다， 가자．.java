import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		
		int N = Integer.parseInt(st.nextToken());	// 세로 길이
		int M = Integer.parseInt(st.nextToken());	// 가로 길이
		
		char[][] map = new char[N][M]; 
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		// y, x, 들어올 때 마다 넣기, 배열
		ArrayList<ArrayList<ArrayList<int[]>>> arr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
		    arr.add(new ArrayList<>());
		    for (int j = 0; j < M; j++) {
		        arr.get(i).add(new ArrayList<>());
		    }
		}
		
		Queue<int[]> queue = new LinkedList<int[]>();

		// {y, x, 움직인 거리, 가지고 있는 키};
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '0') {
					arr.get(i).get(j).add(new int[]{i, j, 0, 0, 0, 0, 0, 0, 0});
					queue.add(new int[]{i, j, 0, 0, 0, 0, 0, 0, 0});
				}
			}
		}
		
		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();			
			for (int dir = 0; dir < 4; dir++) {
				int y = tmp[0], x = tmp[1], dist = tmp[2], ak = tmp[3], bk = tmp[4], ck = tmp[5], dk = tmp[6], ek = tmp[7], fk = tmp[8];
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				
				if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
					if (map[ny][nx] == '1') {
						System.out.println(dist + 1);
						return;
					}
					else if (map[ny][nx] == '.' || map[ny][nx] == '0') {
					    boolean iserr = false;
					    for (int[] oArr : arr.get(ny).get(nx)) {
				        	if (oArr[3] == ak && oArr[4] == bk && oArr[5] == ck && oArr[6] == dk && oArr[7] == ek && oArr[8] == fk) {
				        		iserr = true;
				        		break;
				        	}
				        }
					    if (!iserr) {
					    	arr.get(ny).get(nx).add(new int[]{ny, nx, dist + 1, ak, bk, ck, dk, ek, fk});
					    	queue.add(new int[] {ny, nx, dist + 1, ak, bk, ck, dk, ek, fk});
					    }
					} else if (map[ny][nx] == '#') continue;
					else if (map[ny][nx] == 'a' || map[ny][nx] == 'b' || map[ny][nx] == 'c' || map[ny][nx] == 'd' || map[ny][nx] == 'e' || map[ny][nx] == 'f') {
						if (map[ny][nx] == 'a') ak = 1;
						else if (map[ny][nx] == 'b') bk = 1;
						else if (map[ny][nx] == 'c') ck = 1;
						else if (map[ny][nx] == 'd') dk = 1;
						else if (map[ny][nx] == 'e') ek = 1;
						else if (map[ny][nx] == 'f') fk = 1;
						
					    boolean iserr = false;    
					    for (int[] oArr : arr.get(ny).get(nx)) {
				        	if (oArr[3] == ak && oArr[4] == bk && oArr[5] == ck && oArr[6] == dk && oArr[7] == ek && oArr[8] == fk) {
				        		iserr = true;
				        		break;
				        	}
				        }
					    if (!iserr) {
					    	arr.get(ny).get(nx).add(new int[]{ny, nx, dist + 1, ak, bk, ck, dk, ek, fk});
					    	queue.add(new int[] {ny, nx, dist + 1, ak, bk, ck, dk, ek, fk});
					    }
					}
					
					else if (map[ny][nx] == 'A' || map[ny][nx] == 'B' || map[ny][nx] == 'C' || map[ny][nx] == 'D' || map[ny][nx] == 'E' || map[ny][nx] == 'F') {
						if (map[ny][nx] == 'A' && ak == 0) continue;
						else if (map[ny][nx] == 'B' && bk == 0) continue;
						else if (map[ny][nx] == 'C' && ck == 0) continue;
						else if (map[ny][nx] == 'D' && dk == 0) continue;
						else if (map[ny][nx] == 'E' && ek == 0) continue;
						else if (map[ny][nx] == 'F' && fk == 0) continue;
						
					    boolean iserr = false;    
					    for (int[] oArr : arr.get(ny).get(nx)) {
				        	if (oArr[3] == ak && oArr[4] == bk && oArr[5] == ck && oArr[6] == dk && oArr[7] == ek && oArr[8] == fk) {
				        		iserr = true;
				        		break;
				        	}
				        }
					    if (!iserr) {
					    	arr.get(ny).get(nx).add(new int[]{ny, nx, dist + 1, ak, bk, ck, dk, ek, fk});
					    	queue.add(new int[] {ny, nx, dist + 1, ak, bk, ck, dk, ek, fk});
					    }
					}
				}
			}
		}
		
		System.out.println(-1);
	}
}