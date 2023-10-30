import java.util.Scanner;

public class Main {
    public static void Base() {
         Scanner scan = new Scanner(System.in);
         // Вводим переменные
         System.out.print("Введите значения y, k, x: ");
         double y = scan.nextDouble();
         double k = scan.nextDouble();
         double x = scan.nextDouble();
         // Создаем переменную U и присваиваем значение выражения
         double U = Math.pow(Math.E, y) + 7.355 * Math.pow(k, 2) + Math.pow(Math.sin(Math.toDegrees(x)), 2);
         System.out.printf("U = %.4f\n\n", U);
    }
    public static void Medium() {
        Scanner scan = new Scanner(System.in);
        // Вводим переменные
        System.out.print("Введите значения t, y: ");
        double t = scan.nextDouble();
        double y = scan.nextDouble();
        // Проверка для исключения NaN.
        while (y + 4.831 < 0 || Math.sqrt(y + 4.831) == 0) {
            System.out.print("Введите значения t, y снова: ");
            t = scan.nextDouble();
            y = scan.nextDouble();
        }
        // Создаем переменную Z и присваиваем значение выражения
        double Z = (2 * t + y * Math.cos(Math.toDegrees(t))) / (Math.sqrt(y + 4.831));
        System.out.printf("Z = %.4f\n\n", Z);
    }
    public static void Hard() {
        Scanner scan = new Scanner(System.in);
        // Вводим переменные
        System.out.print("Введите значения x, y: ");
        double x = scan.nextDouble();
        double y = scan.nextDouble();
        // Проверка для исключения NaN.
        while (Math.atan(Math.toDegrees(x)) + 5.2 * y == 0 ) {
            System.out.print("Введите значения x, y снова: ");
            x = scan.nextDouble();
            y = scan.nextDouble();
        }
        // Создаем переменную U и присваиваем значение выражения
        double U = (Math.pow(Math.E, Math.pow(x, 3)) + Math.pow(Math.cos(Math.toDegrees(x - 4)), 2)) / (Math.atan(Math.toDegrees(x)) + 5.2 * y);
        System.out.printf("U = %.4f\n", U);
    }

    public static void main(String[] args) {
        // Вызываем описанные выше функции
        Base();
        Medium();
        Hard();
    }
}