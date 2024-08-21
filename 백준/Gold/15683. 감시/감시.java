import java.io.*;
import java.util.*;

public class Main {

	private static int n, m, minInt;
	private static int[] dx = { 1, 0, -1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };
	private static int[][] arr;
	private static List<int[]> monitoring;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        minInt = Integer.MAX_VALUE; // 최솟값
        
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        monitoring = new ArrayList<>();
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
            	if (arr[i][j] == 6) {
            		visited[i][j] = true;
            	}
            	else if (arr[i][j] != 0) {
                	monitoring.add(new int[]{arr[i][j], i, j});
                	visited[i][j] = true;
                }
            }
        }
        
        dfs(0, visited);
        System.out.println(minInt);
    }
	
    // DFS로 한번 다 돌은 다음 사각지대 확인하고 이어서 돌기
    public static void dfs(int k, boolean[][] visited) {
        if (k == monitoring.size()) {
        	int cnt = 0;
        	for (int r = 0; r < n; r++) {
        		for (int c = 0; c < m; c++) {
        			if (!visited[r][c]) cnt++;
        		}
        	}
        	if (minInt > cnt) minInt = cnt;
        	return;
        }
        
    	if (monitoring.get(k)[0] == 1) {
        	for (int dir = 0; dir < 4; dir++) {
        		int ny = monitoring.get(k)[1] + dy[dir];
        		int nx = monitoring.get(k)[2] + dx[dir];
        		boolean[][] tmpVisited = new boolean[n][m];
        		for (int i = 0; i < n; i++) {
        		    tmpVisited[i] = visited[i].clone();
        		}
        		
        		while(ny < n && ny >= 0 && nx < m && nx >= 0 && arr[ny][nx] != 6) {
        			tmpVisited[ny][nx] = true;
        			ny += dy[dir];
        			nx += dx[dir];
        		}
        		dfs(k+1, tmpVisited);
        	}
        } else if (monitoring.get(k)[0] == 2) {
        	for (int dir = 0; dir < 2; dir++) {
        		int ny = monitoring.get(k)[1] + dy[dir];
        		int nx = monitoring.get(k)[2] + dx[dir];
        		int my = monitoring.get(k)[1] + dy[dir + 2];
        		int mx = monitoring.get(k)[2] + dx[dir + 2];
        		boolean[][] tmpVisited = new boolean[n][m];
        		for (int i = 0; i < n; i++) {
        		    tmpVisited[i] = visited[i].clone();
        		}
        		
        		while(ny < n && ny >= 0 && nx < m && nx >= 0 && arr[ny][nx] != 6) {
        			tmpVisited[ny][nx] = true;
        			ny += dy[dir];
        			nx += dx[dir];
        		}
        		
        		while(my < n && my >= 0 && mx < m && mx >= 0 && arr[my][mx] != 6) {
        			tmpVisited[my][mx] = true;
        			my += dy[dir + 2];
        			mx += dx[dir + 2];
        		}
        		dfs(k+1, tmpVisited);
        	}
        } else if (monitoring.get(k)[0] == 3) {
        	for (int dir = 0; dir < 4; dir++) {
        		int ny = monitoring.get(k)[1] + dy[dir];
        		int nx = monitoring.get(k)[2] + dx[dir];
        		int my = monitoring.get(k)[1] + dy[(dir + 1) % 4];
        		int mx = monitoring.get(k)[2] + dx[(dir + 1) % 4];
        		boolean[][] tmpVisited = new boolean[n][m];
        		for (int i = 0; i < n; i++) {
        		    tmpVisited[i] = visited[i].clone();
        		}
        		
        		while(ny < n && ny >= 0 && nx < m && nx >= 0 && arr[ny][nx] != 6) {
        			tmpVisited[ny][nx] = true;
        			ny += dy[dir];
        			nx += dx[dir];
        		}
        		
        		while(my < n && my >= 0 && mx < m && mx >= 0 && arr[my][mx] != 6) {
        			tmpVisited[my][mx] = true;
        			my += dy[(dir + 1) % 4];
        			mx += dx[(dir + 1) % 4];
        		}
        		dfs(k+1, tmpVisited);
        	}
        } else if (monitoring.get(k)[0] == 4) {
        	for (int dir = 0; dir < 4; dir++) {
        		int ny = monitoring.get(k)[1] + dy[dir];
        		int nx = monitoring.get(k)[2] + dx[dir];
        		int my = monitoring.get(k)[1] + dy[(dir + 1) % 4];
        		int mx = monitoring.get(k)[2] + dx[(dir + 1) % 4];
        		int ly = monitoring.get(k)[1] + dy[(dir + 3) % 4];
        		int lx = monitoring.get(k)[2] + dx[(dir + 3) % 4];
        		boolean[][] tmpVisited = new boolean[n][m];
        		for (int i = 0; i < n; i++) {
        		    tmpVisited[i] = visited[i].clone();
        		}
        		
        		while(ny < n && ny >= 0 && nx < m && nx >= 0 && arr[ny][nx] != 6) {
        			tmpVisited[ny][nx] = true;
        			ny += dy[dir];
        			nx += dx[dir];
        		}
        		
        		while(my < n && my >= 0 && mx < m && mx >= 0 && arr[my][mx] != 6) {
        			tmpVisited[my][mx] = true;
        			my += dy[(dir + 1) % 4];
        			mx += dx[(dir + 1) % 4];
        		}
        		
        		while(ly < n && ly >= 0 && lx < m && lx >= 0 && arr[ly][lx] != 6) {
        			tmpVisited[ly][lx] = true;
        			ly += dy[(dir + 3) % 4];
        			lx += dx[(dir + 3) % 4];
        		}
        		dfs(k+1, tmpVisited);
        	}
        } else if (monitoring.get(k)[0] == 5) {
    		int ny = monitoring.get(k)[1] + dy[0];
    		int nx = monitoring.get(k)[2] + dx[0];
    		int my = monitoring.get(k)[1] + dy[1];
    		int mx = monitoring.get(k)[2] + dx[1];
    		int ly = monitoring.get(k)[1] + dy[2];
    		int lx = monitoring.get(k)[2] + dx[2];
    		int oy = monitoring.get(k)[1] + dy[3];
    		int ox = monitoring.get(k)[2] + dx[3];
    		boolean[][] tmpVisited = new boolean[n][m];
    		for (int i = 0; i < n; i++) {
    		    tmpVisited[i] = visited[i].clone();
    		}
    		
    		while(ny < n && ny >= 0 && nx < m && nx >= 0 && arr[ny][nx] != 6) {
    			tmpVisited[ny][nx] = true;
    			ny += dy[0];
    			nx += dx[0];
    		}
    		
    		while(my < n && my >= 0 && mx < m && mx >= 0 && arr[my][mx] != 6) {
    			tmpVisited[my][mx] = true;
    			my += dy[1];
    			mx += dx[1];
    		}
    		
    		while(ly < n && ly >= 0 && lx < m && lx >= 0 && arr[ly][lx] != 6) {
    			tmpVisited[ly][lx] = true;
    			ly += dy[2];
    			lx += dx[2];
    		}
    		
    		while(oy < n && oy >= 0 && ox < m && ox >= 0 && arr[oy][ox] != 6) {
    			tmpVisited[oy][ox] = true;
    			oy += dy[3];
    			ox += dx[3];
    		}
    		dfs(k+1, tmpVisited);
        }
    }
}