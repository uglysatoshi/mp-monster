import java.util.Scanner;

public class Main {
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        // Вводим до какого члена будет продолжаться последовательность
        System.out.print("Введите целое число N (N>0): ");
        int N = scan.nextInt();
        // Проверка
        while (N < 0) {
            System.out.print("Введите целое число N (N>0): ");
            N = scan.nextInt();
        }
        // Вводим значение x
        System.out.print("Введите вещественное число Х: ");
        double X = scan.nextDouble();
        // Находим сумму последовательности
        double ans = 0;
        for (int i = 1; i <= N; i++) {
            ans += -1*i - 1*X*i/i;
        }
        // Выводим ответ
        System.out.printf("Сумма: %.2f\n\n", ans);
    }
    public static void Medium() {
        Scanner scan = new Scanner(System.in);
        // Объявляем и вводим k и n
        System.out.print("Введите целые числа kи n(k < n): ");
        int k = scan.nextInt();
        int n = scan.nextInt();
        // k не может быть больше n
        while(k > n) {
            System.out.print("Введите целые числа k и n(k < n): ");
            k = scan.nextInt();
            n = scan.nextInt();
        }
        // Суммируем от k до n
        double Q = 0;
        for (int i = k; i <= n; i++) {
            Q += Math.pow(k - 3, k - 5) * (k+7) / getFactorial(k);
        }
        // Выводим Q
        System.out.printf("Q: %.1f", Q);
    }
    // Функция для нахождения факториала
    private static int getFactorial(int f) {
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result = result * i;
        }
        return result;
    }
    public static void main(String[] args) {
        Base();
        Medium();
    }
}