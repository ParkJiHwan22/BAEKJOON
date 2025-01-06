import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		if (N % 2 == 0) System.out.println("CY");
		else if (N % 2 == 1) System.out.println("SK");		
	}
}