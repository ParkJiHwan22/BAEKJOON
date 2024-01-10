import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int chicken = scanner.nextInt();
        scanner.nextLine(); // 정수 입력 후 남은 개행문자를 소비

        String line = scanner.nextLine(); // 전체 라인을 문자열로 입력 받음

        // 입력된 문자열을 공백을 기준으로 분리
        String[] parts = line.split(" ");
        int cola = Integer.parseInt(parts[0]); // 첫 번째 정수
        int beer = Integer.parseInt(parts[1]); // 두 번째 정수

        int result = Math.min((cola / 2) + beer, chicken);
        System.out.println(result);

        scanner.close();
    }
}
