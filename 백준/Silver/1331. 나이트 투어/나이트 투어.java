import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[][] visited = new boolean[6][6];
		boolean iserr = false;
		
		String str = br.readLine();
		int start_Y = str.charAt(0) - 'A';
		int start_X = str.charAt(1) - '1';
		int before_Y = start_Y;
		int before_X = start_X;
		visited[before_Y][before_X] = true;

		for (int i = 0; i < 35; i++) {
			str = br.readLine();
			int y = str.charAt(0) - 'A';
			int x = str.charAt(1) - '1';
			
			if (!visited[y][x] && ((Math.abs(before_Y - y) == 2 && (Math.abs(before_X - x) == 1)) || (Math.abs(before_Y - y) == 1 && (Math.abs(before_X - x) == 2)))){
				visited[y][x] = true;
				before_Y = y;
				before_X = x;
				
			} else {
				iserr = true;
				break;
			}
		}
		
		
		if ((Math.abs(before_Y - start_Y) == 2 && (Math.abs(before_X - start_X) == 1)) || (Math.abs(before_Y - start_Y) == 1 && (Math.abs(before_X - start_X) == 2)));
		else iserr = true;
		
		if (!iserr) System.out.println("Valid");
		else System.out.println("Invalid");
	}
}