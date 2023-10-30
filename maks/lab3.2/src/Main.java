import java.util.Scanner;

public class Main {
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        // Объявляем и заполняем переменные n, m
        System.out.print("Введите значения m и n: ");
        int m = scan.nextInt();
        int n = scan.nextInt();
        // Объявляем переменную для суммирования
        int sum = 0;
        for(int i = m; i <= n; i++) {
            sum += (int) Math.pow(i, 2);
        }
        // Выводим итоговую сумму
        System.out.printf("Сумма квадратов чисел от m до n: %d\n\n", sum);
    }
    public static void Medium() {
        Scanner scan = new Scanner(System.in);
        // Объявляем переменную m и заполняем ее
        System.out.print("Введите число m: ");
        int m = scan.nextInt();
        // Объявляем переменную для суммирования
        int sum = 0;
        for(int i = 100; i <= 1000; i+= 200) {
            sum += (int) (Math.pow(i, 3) * m);
        }
        // Выводим итоговую сумму
        System.out.printf("Сумма квадратов чисел от m до n: %d\n\n", sum);
    }
    public static void Hard() {
        Scanner scan = new Scanner(System.in);
        // Объявляем переменную n и заполняем ее
        System.out.print("Введите число n: ");
        int n = scan.nextInt();
        // Объявляем переменную для суммирования
        int sum = 0;
        // Проверяем число на совершенность
        for (int i = n - 1; i > 0; i-- ) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    sum += j;
                }
            }
            if (sum == i) {
                System.out.printf("Число %d совершенно\n", sum);
            }
            sum = 0;
        }
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}