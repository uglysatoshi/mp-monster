import java.util.Scanner;

public class Main {
    public static void Base() {
        boolean A = true;
        boolean B = false;
        boolean C = true;
        System.out.printf("Первое выражение: %b\nВторое выражение: %b\nТретье выражение: %b\n\n", A || !(A && B) || C, !A || C && !(B || C), (A || B && !C) || A );
    }
    public static void Medium() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        int a = scan.nextInt();
            if (a % 2 == 0 && a % 3 != 0 && a % 7 == 0) {
                if (a % 5 != 0 && a % 4 == 0) {
                    System.out.printf("Число %d истинно\n\n", a);
                    return;
                } else {
                    if (a % 8 == 0 && a % 11 == 0) {
                        System.out.printf("Число %d истинно\n\n", a);
                        return;
                    }
                    System.out.printf("Число %d не истинно\n\n", a);
                    return;
                }
            }
            System.out.printf("Число %d не истинно\n\n", a);
    }
    public static void Hard() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите координаты точки: ");
        double x = scan.nextDouble();
        double y = scan.nextDouble();
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