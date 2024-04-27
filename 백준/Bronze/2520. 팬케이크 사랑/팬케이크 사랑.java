import java.io.*;
import java.util.*;

public class Main {
	public static double MILK = 0.5; //우유 8컵 
	public static double YOLK = 0.5; //노른자 8개
	public static double SUGAR = 0.25; //설탕 4스푼
	public static double SALT = 0.0625; //소금 1스푼
	public static double FLOUR = 0.5625; //밀가루 9컵

	public static int BANANA = 1; //바나나 1개 
	public static int STRAWBERRY_JAM = 30; //딸기잼 30그램
	public static int CHOCHOLATE = 25; //초콜릿 25그램
	public static int WALNUT = 10; //호두 10개
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++){
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());

			int c =  (int) (Integer.parseInt(st.nextToken())/MILK);
			int y =  (int) (Integer.parseInt(st.nextToken())/YOLK);
			int su = (int) (Integer.parseInt(st.nextToken())/SUGAR); 
			int sa = (int) (Integer.parseInt(st.nextToken())/SALT); 
			int f =  (int) (Integer.parseInt(st.nextToken())/FLOUR);
			
			int cake = Math.min(c, Math.min(y, Math.min(su, Math.min(sa, f))));

			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken())/BANANA;
			int sg = Integer.parseInt(st.nextToken())/STRAWBERRY_JAM;
			int cg = Integer.parseInt(st.nextToken())/CHOCHOLATE;
			int w = Integer.parseInt(st.nextToken())/WALNUT;
			
			int sum = b + sg + cg + w;
			
			int result = Math.min(cake, sum);

			System.out.println(result);
			
		}	
	}
}