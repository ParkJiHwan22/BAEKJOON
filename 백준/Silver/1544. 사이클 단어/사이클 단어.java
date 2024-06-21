import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfStrings = Integer.parseInt(br.readLine());
        ArrayList<String>[] rotationsArray = new ArrayList[numberOfStrings];
        int uniqueCount = 0;

        for (int i = 0; i < numberOfStrings; i++) {
            rotationsArray[i] = new ArrayList<>();
            String currentString = br.readLine();

            for (int j = 0; j < currentString.length(); j++) {
                rotationsArray[i].add(currentString.substring(j) + currentString.substring(0, j));
            }

            boolean isUnique = true;
            for (int j = 0; isUnique && j <= i - 1; j++) {
                for (int k = 0; isUnique && k < rotationsArray[j].size(); k++) {
                    if (currentString.equals(rotationsArray[j].get(k))) {
                        isUnique = false;
                    }
                }
            }

            if (isUnique) {
                uniqueCount++;
            }
        }

        System.out.println(uniqueCount);
    }
}