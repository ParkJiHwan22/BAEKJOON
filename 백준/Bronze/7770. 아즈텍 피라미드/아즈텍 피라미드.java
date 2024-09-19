import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        int n = Integer.parseInt(br.readLine());
        int totalBlock = 1;
        int block = 1;
        int turn = 0;
        
        while (totalBlock <= n) {
        	turn++;
        	block += (4 * turn);
        	totalBlock += block;
        }
        
        System.out.println(turn);
    }
}