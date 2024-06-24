import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumber = scanner.nextInt();

        List<Integer> maxSequence = new ArrayList<>();
        int maxLength = 0;

        for (int secondNumber = 1; secondNumber <= firstNumber; secondNumber++) {
            List<Integer> currentSequence = new ArrayList<>();
            currentSequence.add(firstNumber);
            currentSequence.add(secondNumber);

            while (true) {
                int size = currentSequence.size();
                int nextNumber = currentSequence.get(size - 2) - currentSequence.get(size - 1);
                if (nextNumber < 0) {
                    break;
                }
                currentSequence.add(nextNumber);
            }

            if (currentSequence.size() > maxLength) {
                maxLength = currentSequence.size();
                maxSequence = currentSequence;
            }
        }

        System.out.println(maxLength);
        for (int i = 0; i < maxSequence.size(); i++) {
            System.out.print(maxSequence.get(i));
            if (i < maxSequence.size() - 1) {
                System.out.print(" ");
            }
        }
    }
}