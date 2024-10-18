import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        int n = Integer.parseInt(br.readLine());
        
        // ArrayList<Map<Integer, HashSet<Integer>>> 초기화
        ArrayList<Map<Integer, HashSet<Integer>>> arr = new ArrayList<>();
        for (int i = 0; i < n+2; i++) {
            Map<Integer, HashSet<Integer>> newHm = new HashMap<>();
            arr.add(newHm);
        }
        
        // 첫 번째 맵에 (1, [0]) 추가
        arr.get(0).put(1, new HashSet<>(Arrays.asList(0)));
        
        for (int i = 0; i <= n; i++) {
            Map<Integer, HashSet<Integer>> hm = arr.get(i);
            Iterator<Map.Entry<Integer, HashSet<Integer>>> hmIterator = hm.entrySet().iterator();
    
            while (hmIterator.hasNext()) {
                Map.Entry<Integer, HashSet<Integer>> entry = hmIterator.next();
                int key = entry.getKey();
                HashSet<Integer> valSet = entry.getValue();
                
                if (key == n) {
                    System.out.println(i);
                    return;
                }
                
                for (int val : valSet) {  // Set에서 값을 하나씩 처리
                    // 1. 클립보드에 저장
                    arr.get(i+1).putIfAbsent(key, new HashSet<>());
                    arr.get(i+1).get(key).add(key);  // 중복되지 않게 key 추가

                    // 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기
                    arr.get(i+1).putIfAbsent(key + val, new HashSet<>());
                    arr.get(i+1).get(key + val).add(val);  // 중복되지 않게 추가

                    // 3. 화면에 있는 이모티콘 중 하나를 삭제
                    if (key > 0) {
                        arr.get(i+1).putIfAbsent(key - 1, new HashSet<>());
                        arr.get(i+1).get(key - 1).add(val);  // 중복되지 않게 추가
                    }
                }
            }
        }        
    }
}
