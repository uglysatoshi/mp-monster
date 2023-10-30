import java.util.Scanner;

public class Main {
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        // Вводим до какого члена будет продолжаться последовательность
        System.out.print("Введите значение N: ");
        int N = scan.nextInt();
        // Проверка
        while (N <= 0) {
            System.out.print("Введите значение N: ");
            N = scan.nextInt();
        }
        // Находим произведение последовательности
        double ans = 2;
        for(int i = 2; i <= N; i++) {
            ans *= (double) 1 / i;
        }
        // Выводим ответ
        System.out.printf("Произведение: %.8f\n\n", ans);
    }
    public static void Medium() {
        Scanner scan = new Scanner(System.in);
        // Объявляем и вводим k и n
        System.out.print("Введите значение n и k: ");
        int n = scan.nextInt();
        int k = scan.nextInt();
        // Проверка на отрицательность
        while (n <= 0) {
            System.out.print("Введите значение n: ");
            n = scan.nextInt();
        }
        // Суммируем от k до n
        double Q = 0;
        for (int i = k; i < n; i++) {
            Q += Math.pow(-1, k) * (k - 7) / getFactorial(k + n);
        }
        // Выводим Q
        System.out.printf("Q: %.8f\n\n", Q);
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