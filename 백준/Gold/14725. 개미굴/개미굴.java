import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        Map<String, Node> childNode = new TreeMap<>();
        boolean endOfWord;
    }

    static class Trie {
        Node rootNode = new Node();

        // 문자열 배열을 Trie에 삽입하는 함수
        void insert(String[] arr) {
            Node node = rootNode;
            for (String str : arr) {
                // 자식 노드 중 동일한 문자열이 없으면 새 노드 생성
                node = node.childNode.computeIfAbsent(str, key -> new Node());
            }
            node.endOfWord = true;  // 단어의 끝임을 표시
        }

        void printTrie(Node node, int depth) {
            // 현재 노드의 자식 노드를 순차적으로 탐색
            for (Map.Entry<String, Node> entry : node.childNode.entrySet()) {
                // 층(depth)에 따라 "--"를 출력하여 계층 구조를 표현
                for (int i = 0; i < depth; i++) {
                    System.out.print("--");
                }
                System.out.println(entry.getKey());  // 현재 노드(방 이름)를 출력
                // 재귀적으로 자식 노드를 탐색하고 출력
                printTrie(entry.getValue(), depth + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());  // 첫 번째 줄에서 N을 입력받음
        Trie trie = new Trie();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int k = Integer.parseInt(input[0]);  // 첫 번째 값은 K
            String[] foodItems = Arrays.copyOfRange(input, 1, k + 1);  // 먹이 정보를 배열로 추출
            trie.insert(foodItems);  // 먹이 정보 삽입
        }

        trie.printTrie(trie.rootNode, 0);
    }
}