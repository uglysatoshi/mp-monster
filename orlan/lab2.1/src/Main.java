import java.util.Scanner;

public class Main {
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        // Объявляем и вводим число a
        System.out.print("Введите число: ");
        int a = scan.nextInt();
        // Проверяем трехзначное ли число
        if (Math.abs(a) <= 999 && Math.abs(a) >= 100) {
            // число трехзначное
            System.out.printf("Число %d трёхзначное\n\n", a);
        } else {
            // число не трехзначное
            System.out.printf("Число %d не трёхзначное\n\n", a);
        }
    }
    public static void Medium() {
        Scanner scan = new Scanner(System.in);
        // Объявляем и вводим переменные k, l, n, m
        System.out.print("Введите значения k, l, n, m: ");
        int k = scan.nextInt();
        int l = scan.nextInt();
        int n = scan.nextInt();
        int m = scan.nextInt();
        // Исходя из задания проверяем на истинность
        if (k + l + m + n > 0) {
            if (k > 0) {
                if (2*m > l) {
                    System.out.print("Выражение истинно\n\n");
                    return;
                }
                System.out.print("Выражение не истинно\n\n");
                return;
            } else {
                if(n > 3 * l) {
                    System.out.print("Выражение истинно\n\n");
                     return;
                }
                System.out.print("Выражение не истинно\n\n");
                return;
            }
        }
        System.out.print("Выражение не истинно\n\n");
    }
    public static void Hard() {
        Scanner scan = new Scanner(System.in);
        // Объявляем переменные x, y и вводим их
        System.out.print("Введите координаты точки: ");
        double x = scan.nextDouble();
        double y = scan.nextDouble();
        // проверяем входит ли точка в заштрихованную область
        if(y >= x && y >= -x && y <= 1) {
            System.out.print("Точка попадает в заштрихованную область");
        } else {
            System.out.print("Точка не попадает в заштрихованную область");
        }
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}