import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }
        
        int maxPrefix = -1;  // 최대 접두사 길이
        int firstIdx = 0;    // 첫 번째 단어의 인덱스
        int secondIdx = 0;   // 두 번째 단어의 인덱스
        
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int prefixLen = getCommonPrefixLength(words[i], words[j]);
                
                if (prefixLen > maxPrefix) {
                    maxPrefix = prefixLen;
                    firstIdx = i;
                    secondIdx = j;
                }
            }
        }
        
        System.out.println(words[firstIdx]);
        System.out.println(words[secondIdx]);
    }
    
    private static int getCommonPrefixLength(String str1, String str2) {
        int minLen = Math.min(str1.length(), str2.length());
        int prefixLen = 0;
        
        for (int i = 0; i < minLen; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                prefixLen++;
            } else {
                break;
            }
        }
        
        return prefixLen;
    }
}