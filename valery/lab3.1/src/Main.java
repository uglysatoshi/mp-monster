import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static final double scale = Math.pow(10,3);
    public static int Factorial(int number) { // функция нахождения факториала
        int result = 1; // начинаем с единицы так как 0 * 1 будет ноль и мы получим некоректное число
        for (int i = 1; i <= number; i++) { // пока не будет равно поадному числу
            result *= i; // перемножаем
        }
        return result;
    }
    public static void Base() {

        System.out.print("Введите значение N: "); int N = in.nextInt();
        int k = N / 3; // находим минимальное K, чтобы 3K > N
        int smallest = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int num = 3 * i;
            if (num < N && num > smallest) { // если число больше N и меньше текущего наименьшего
                smallest = num;
            }
        }
        System.out.println("Значение 3K: " + 3 * k);
        System.out.println("Наименьшее значение: " + smallest);
    }

    public static void Medium() {
        System.out.print("Введите значение k: "); int k = in.nextInt();
        double W = 0;
        for (int i = -2; i < k; i++) {
            int factorial = Factorial(i + 3);
            // условие выхода, если предвидится деление на ноль
            if (i - 4 == 0)
                continue;
            W += (Math.pow(-1, i) * factorial) / (i - 4);
        }
        System.out.println("Значение W: " + Math.ceil(W * scale) / scale);
    }
    public static void main(String[] args) {
        Base();
        Medium();
    }
}