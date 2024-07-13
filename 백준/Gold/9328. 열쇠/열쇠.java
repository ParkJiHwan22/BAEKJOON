import java.io.*;
import java.util.*;

public class Main {
	
	private static boolean[][] visited;
	private static boolean[] keys;
	private static Queue<int[]> locked, queue;
	private static Character[][] room;	
	private static int cnt, h, w;	
	
	public static void main(String[] args) throws IOException, NullPointerException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};

		for (int t = 0; t < T; t++) {
			// 1. 입력 받기
			cnt = 0; // 결과
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			room = new Character[h][w];
			visited = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				String str = br.readLine();
				for (int j = 0; j < w; j++) {
					room[i][j] = str.charAt(j);
				}
			}
			
			keys = new boolean[26];
			String key = br.readLine();
			if (!key.equals("0")) {
				for (int i = 0; i < key.length(); i++) {
					keys[key.charAt(i) - 'a'] = true;
				}
			}
			
			// 2. 계산
			queue = new LinkedList<>();
			locked = new LinkedList<>();
			for (int i = 0; i < w; i++) {
				queueMethod(0, i);
				queueMethod(h-1, i);
			}
			for (int i = 1; i < h-1; i++) {
				queueMethod(i, 0);
				queueMethod(i, w-1);				
			}
			
			Queue<int[]> tempLocked = new LinkedList<>(locked);
			locked.clear();
			for (int[] lock : tempLocked) {
				if (keys[lock[2]]) {
					queue.add(new int[]{lock[0], lock[1]});
					visited[lock[0]][lock[1]] = true;
				} else {
					locked.add(lock);
				}
			}
			
			
			while(!queue.isEmpty()) {
				int[] tmp = queue.poll();

				for (int dir = 0; dir < 4; dir++) {
					int y = tmp[0] + dy[dir];
					int x = tmp[1] + dx[dir];
					
					queueMethod(y, x);
				}
			}
			
			System.out.println(cnt);			
		}
	}
	
	private static void queueMethod(int y, int x) {
		if (0 <= y && y < h && 0 <= x && x < w && !visited[y][x]) {
			
			if (0 <= room[y][x] - 'A' && room[y][x] - 'A' < 26) { // 1. 알파벳 대문자
				if (keys[room[y][x] - 'A']) {
					queue.add(new int[]{y, x});
					visited[y][x] = true;
				} else {
					locked.add(new int[]{y, x, room[y][x] - 'A'});
				}
			} else if (0 <= room[y][x] - 'a' && room[y][x] - 'a' < 26) { // 2. 알파벳 소문자
				queue.add(new int[]{y, x});
				visited[y][x] = true;
				if (!keys[room[y][x] - 'a']) {
					keys[room[y][x] - 'a'] = true;
					Queue<int[]> tempLocked = new LinkedList<>(locked);
					locked.clear();
					for (int[] lock : tempLocked) {
						if (lock[2] == room[y][x] - 'a') {
							queue.add(new int[]{lock[0], lock[1]});
							visited[lock[0]][lock[1]] = true;
						} else {
							locked.add(lock);
						}
					}
				}

			} else if (room[y][x] == '$') { // 3. 문서 줍줍
				cnt++;
				visited[y][x] = true;
				queue.add(new int[]{y, x});
			} else if (room[y][x] == '.') { // 4. 이동 가능
				visited[y][x] = true;
				queue.add(new int[]{y, x});
			}
		}
	}
}