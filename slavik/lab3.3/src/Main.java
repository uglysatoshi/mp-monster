import java.util.Scanner;

public class Main {
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        // Объявляем и вводим значение x
        System.out.print("Введите значение x: ");
        double x = scan.nextDouble();
        // Объявляем переменную term и присваиваем ей тело последовательности
        double term = (x - 1) / (x + 1);
        // Объявляем переменную для суммирования прогрессии
        double sum = term;
        for (int i = 3; ; i += 2) {
            sum += (double) 1 / i * Math.pow(term, i);
            // Ограничение последовательности
            if (Math.abs((double)1/i) < 0.000000001) {
                break;
            }
        }
        System.out.printf("Сумма бесконечной геометрической прогрессии: %.6f", sum);
    }
    public static void main(String[] args) {
        Base();
    }
}