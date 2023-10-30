import java.util.Scanner;

public class Main {
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        // Объявляем и вводим значение x
        System.out.print("Введите значение x: ");
        double x = scan.nextDouble();
        // Объявляем переменную для суммирования прогрессии
        double sum = 0;
        for (int i = 1; ; i += 1) {
            double body = Math.pow(x, i) * Math.cos(i * Math.PI/3) / i;
            sum += body;
            // Ограничение последовательности
            if (Math.abs(body) > 100000000) {
                break;
            }
        }
        System.out.printf("Сумма бесконечной геометрической прогрессии: %.2f", sum);
    }
    public static void main(String[] args) {
        Base();
    }
}