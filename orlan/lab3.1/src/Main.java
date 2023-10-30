import java.util.Scanner;

public class Main {
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        // Объявляем и вводим N
        System.out.print("Введите число N (N>0): ");
        int N = scan.nextInt();
        while(N < 0) {
            System.out.print("Введите число N (N>0): ");
            N = scan.nextInt();
        }
        System.out.print("Введите число X: ");
        double X = scan.nextDouble();
        double ans = 1;
        for(int i = 2; i <= N; i++) {
            ans += (-1*i*X*2*i+1) / 2*i+1;
        }
        System.out.printf("Сумма последовательности: %.2f\n\n", ans);
    }
    public static void Medium() {
        Scanner scan = new Scanner(System.in);
        // Объявляем и вводим k
        System.out.print("Введите число k (k>0): ");
        int k = scan.nextInt();
        // Проверка
        while(k < 0) {
            System.out.print("Введите число k (N>0): ");
            k = scan.nextInt();
        }

        double W1 = 0;
        double W2 = 1;
        //  Суммирование
        for(int i = 1; i <= k; i++) {
            W1 += Math.pow(-1, i) / Math.pow(i - 3, 2);
        }
        // Произведение
        for(int i = 1; i < k; i++) {
            W2 *= (Math.pow(i ,3) - 8) / i + 2;
        }
        // Выводим произведение суммы и произведения
        System.out.printf("W = %f", W1 * W2);
    }
    public static void main(String[] args) {
        Base();
        Medium();
    }
}