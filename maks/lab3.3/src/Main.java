import java.util.Scanner;

public class Main {
    // Функция для нахождения факториала
    private static int factorial(int f) {
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result = result * i;
        }
        return result;
    }
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        // Объявляем и вводим значение x
        System.out.print("Введите значение x: ");
        double x = scan.nextDouble();
        // Объявляем переменную для суммирования прогрессии
        double sum = 1;
        for (int i = 1; ; i += 1) {
            sum += Math.cos(i * x) / factorial(i);
            // Ограничение последовательности
            if (Math.abs(Math.cos(i * x) / factorial(i)) < 0.000000001) {
                break;
            }
        }
        System.out.printf("Сумма бесконечной геометрической прогрессии: %.6f", sum);
    }
    public static void main(String[] args) {
        Base();
    }
}
