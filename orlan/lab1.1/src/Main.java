import java.util.Scanner;

public class Main {
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        // Объявляем и вводим переменные
        System.out.print("Введите значения t, x: ");
        double t = scan.nextDouble();
        double x = scan.nextDouble();
        // Объявляем переменную K и приравниваем ей значение выражения от t, x
        double K = 7 * Math.pow(t, 2) + 3 * Math.sin(Math.toDegrees(Math.pow(x, 3))) + 9.2;
        // Выводим значение K
        System.out.printf("K = %.4f\n\n", K);
    }
    public static void Medium() {
        Scanner scan = new Scanner(System.in);
        // Объявляем и вводим переменные
        System.out.print("Введите значения t, y: ");
        double t = scan.nextDouble();
        double y = scan.nextDouble();
        // Проводим проверку на NaN
        while (Math.log10(t + y) == 0) {
            System.out.print("Введите значения t, y снова: ");
            t = scan.nextDouble();
            y = scan.nextDouble();
        }
        // Объявляем переменную R и приравниваем ей значение выражения от t, y
        double R = Math.sin(Math.toDegrees(Math.pow((2 * t + 1), 2))) + 0.3 / Math.log10(t + y);
        // Выводим значение R
        System.out.printf("R = %.4f\n\n", R);
    }
    public static void Hard() {
        Scanner scan = new Scanner(System.in);
        // Объявляем и вводим переменные
        System.out.print("Введите значения y, x, a: ");
        double y = scan.nextDouble();
        double x = scan.nextDouble();
        double a = scan.nextDouble();
        // Проводим проверку на NaN
        while (Math.pow(Math.atan(Math.toDegrees(x + a)), 4) * Math.pow(x, 5) == 0) {
            System.out.print("Введите значения y, x, a снова: ");
            y = scan.nextDouble();
            x = scan.nextDouble();
            a = scan.nextDouble();
        }
        // Объявляем переменную G и приравниваем ей значение выражения от y, x, a
        double G = (Math.pow(Math.cos(Math.toDegrees(Math.abs(y + x))), 3) - (x + y)) / (Math.pow(Math.atan(Math.toDegrees(x + a)), 4) * Math.pow(x, 5));
        // Выводим значение G
        System.out.printf("G = %.7f\n", G);
    }
    public static void main(String[] args) {
        // Вызываем выше описанные функции
        Base();
        Medium();
        Hard();
    }
}