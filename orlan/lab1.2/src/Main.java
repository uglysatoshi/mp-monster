import java.util.Scanner;

public class Main {
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        // Вводим переменные a и b
        System.out.print("Введите значения двух сторон треугольника: ");
        double a = scan.nextDouble();
        double b = scan.nextDouble();
        // Защита от ввода отрицательных чисел
        System.out.print("Введите гипотенузу прямоугольного треугольника: ");
        double c = scan.nextDouble();
        while(Math.pow(a, 2) + Math.pow(b, 2) != Math.pow(c, 2)) {
            System.out.print("Треугольник не прямоугольный, заполните стороны a, b снова: ");
            a = scan.nextDouble();
            b = scan.nextDouble();
        }
        double P = (Math.abs(a) * Math.abs(b)) / 2;
        // Выводим получившуюся площадь
        System.out.printf("Площадь прямоугольного треугольника равна %.4f\n\n", P);
    }
    public static void Medium() {
        // Создаем переменные q и b и передаем в них значения по заданию
        double q = 2;
        double b = 1.8;
        // Создаем переменные и передаем в них значения выражений по заданию
        double t = Math.pow(b, 3) + Math.pow(Math.E, Math.sqrt(q));
        double x = Math.pow(t, 3) + Math.pow(b, 2);
        double y = Math.pow(Math.atan(Math.toDegrees(Math.abs(x))), 2);
        // Выводим t, x, y
        System.out.printf("t = %.4f\nx = %.4f\ny = %.4f\n\n", t,x,y);
    }
    public static void Hard() {
        Scanner scan = new Scanner(System.in);
        // Вводим длины отрезков
        System.out.print("Введите значения a и b (a > 0, b > 0, a > b): ");
        double a = scan.nextDouble();
        double b = scan.nextDouble();
        // проводим проверку, чтобы значения не были отрицательными и a < b
        while(a <= 0 || b <= 0 || a < b) {
            System.out.print("Значения не соответствуют одному из условий\nВведите заново: ");
            a = scan.nextDouble();
            b = scan.nextDouble();
        }
        // Выводим количество отрезков b нацело помещающихся в отрезок a
        System.out.printf("Количество отрезков b нацело помещающихся в отрезок a: %d", (int)((int) a/b));
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}