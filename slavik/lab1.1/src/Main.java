import java.util.Scanner;

public class Main {
    public static void Base () {
        Scanner scan = new Scanner(System.in);
        // Объявляем переменную y и вводим ее
        System.out.print("Введите число y: ");
        double y = scan.nextDouble();
        // Создаем переменную E и присваиваем значение выражения от y
        double E = Math.sqrt(Math.abs(3*Math.pow(y, 2) + 0.5*y + 4));
        // Выводим значение E
        System.out.printf("E = %.4f\n\n", E);
    }
    public static void Medium () {
        Scanner scan = new Scanner(System.in);
        // Объявляем переменные y, h и вводим их
        System.out.print("Введите числа y и h: ");
        double y = scan.nextDouble();
        double h = scan.nextDouble();
        // Проводим проверку на NaN
        while (Math.pow(Math.E, h) + y == 0 ) {
            System.out.print("Снова введите числа y и h: ");
            y = scan.nextDouble();
            h = scan.nextDouble();
        }
        // Создаем переменную A и присваиваем значение выражения от y, h
        double A = Math.sin(Math.toDegrees(2 * y + h) + Math.pow(h,2) / Math.pow(Math.E, h) + y);
        // Выводим значение A
        System.out.printf("A = %.4f\n\n", A);
    }
    public static void Hard () {
        Scanner scan = new Scanner(System.in);
        // Объявляем переменные a, b, x и вводим их
        System.out.print("Введите числа a, b, x: ");
        double a = scan.nextDouble();
        double b = scan.nextDouble();
        double x = scan.nextDouble();
        // Проводим проверку на NaN
        while (x - a == 0 || a == 0 || Math.pow((Math.log10(a)), 3) + 4.5 == 0) {
            System.out.print("Снова введите числа a, b, x: ");
            a = scan.nextDouble();
            b = scan.nextDouble();
            x = scan.nextDouble();
        }
        // Создаем переменную R и присваиваем значение выражения от a, b, x
        double R = (a/x-a) + ((Math.pow(b,x) + Math.pow(Math.cos(Math.toDegrees(x)), 3)) / (Math.pow((Math.log10(a)), 3) + 4.5));
        // Выводим значение R
        System.out.printf("R = %.4f\n\n", R);
    }

    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}