import java.io.*;
import java.util.*;

public class Main {
    
    private static boolean[] visited = new boolean[26];
    private static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            String[] words = str.split(" ");
            List<String> list = new ArrayList<>(Arrays.asList(words));
            
            if (!isFirstWord(list, str)) allWord(str);
        }
        
        System.out.println(sb);
    }
    
    public static boolean isFirstWord(List<String> list, String str) {
        for (int j = 0; j < list.size(); j++) {
            int idx = Character.toLowerCase(list.get(j).charAt(0)) - 'a';
            
            if (!visited[idx]) {
                visited[idx] = true;
                for (int k = 0; k < list.size(); k++) {
                    if (k > 0) sb.append(" ");  // 단어 사이에 공백 추가
                    if (j != k) {
                        sb.append(list.get(k));
                    } else {
                        sb.append("[");
                        sb.append(list.get(j).charAt(0));
                        sb.append("]");
                        sb.append(list.get(j).substring(1));
                    }
                }
                sb.append("\n");
                return true;
            }
        }
        return false;
    }
    
    public static void allWord(String str) {
        for (int j = 0; j < str.length(); j++) {
            if (str.charAt(j) == ' ') continue;
            
            int idx = Character.toLowerCase(str.charAt(j)) - 'a';
            
            if (!visited[idx]) {
                visited[idx] = true;
                sb.append(str.substring(0, j));
                sb.append("[");
                sb.append(str.charAt(j));
                sb.append("]");
                sb.append(str.substring(j + 1));
                sb.append("\n");
                return;
            }
        }
        sb.append(str).append("\n");
    }
}